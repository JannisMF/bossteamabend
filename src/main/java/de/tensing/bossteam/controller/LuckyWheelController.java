package de.tensing.bossteam.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.tensing.bossteam.entities.News;
import de.tensing.bossteam.entities.Player;
import de.tensing.bossteam.entities.Price;
import de.tensing.bossteam.entities.dtos.LuckyWheelPriceDTO;
import de.tensing.bossteam.entities.enums.LuckyWheelPrice;
import de.tensing.bossteam.utils.Actions;
import de.tensing.bossteam.utils.QrCodeGenerator;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static de.tensing.bossteam.entities.Game.*;
import static de.tensing.bossteam.utils.LuckyWheelActions.*;
import static de.tensing.bossteam.utils.Request.getServerUrl;
import static de.tensing.bossteam.utils.TimeConverter.getCurrentTime;

@RestController
@RequestMapping("luckywheel")
public class LuckyWheelController {

    @GetMapping()
    public ModelAndView wheelPage(HttpServletRequest request) {
        List<LuckyWheelPriceDTO> allPrices = getPriceArray();

        ModelAndView mav = new ModelAndView("luckywheel");
        mav.addObject("allPrices", allPrices);
        mav.addObject("wonPrices", PRICE);
        mav.addObject("serverUrl", getServerUrl(request));
        return mav;
    }

    @GetMapping(path = "spin")
    public ModelAndView spinPage(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("spin");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String playerUsername = auth.getName();
        Integer playerId = Integer.parseInt(playerUsername);
        Player p = PLAYERS_LIST.get(playerId - 1);

        mav.addObject("playerId", p.getPlayerId());
        mav.addObject("health", p.getHealth());
        mav.addObject("food", p.getFood());
        mav.addObject("armor", p.getArmor());
        mav.addObject("name", p.getName());
        mav.addObject("serverUrl", getServerUrl(request));

        return mav;
    }

    @GetMapping(path = "spin/qrCode", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] generateQrCode() throws IOException {
        String url = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/..").build().normalize().toString();
        BufferedImage image = QrCodeGenerator.generateQrCodeFrom(url, 400, 400);

        ByteArrayOutputStream bao = new ByteArrayOutputStream();
        ImageIO.write(image, "jpg", bao);
        return bao.toByteArray();
    }

    @GetMapping(path = "spin/spin")
    public String spinWheel() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String playerUsername = auth.getName();
        Integer playerId = Integer.parseInt(playerUsername);
        Player p = PLAYERS_LIST.get(playerId - 1);

        if (!IS_DAY) {
            return "Nachts kannst du nicht am Glücksrad drehen. Probier es Morgen nochmal!";
        }

        if (p.getHealth() == 1) {
            if (p.getArmor() == 0) {
                return "Du kannst nicht drehen, weil du dich sonst selbst Töten würdest!";
            }
        }
        if (p.getHealth() == 0) {
            return "Du bist noch Tod. Gehe in den Todesraum um Wiederbelebt zu werden!";
        }

        Actions.removeHealth(p.getPlayerId());

        int random = (int) (Math.random() * 1000) + 1; // Random num between 1 and 1000.
        LuckyWheelPrice[] allPrices = LuckyWheelPrice.values();
        LuckyWheelPrice thePrice = null;
        int currentPriceProb = 0; // Current Price Probability
        for (LuckyWheelPrice currentPrice : allPrices) {
            if ((random > currentPriceProb) && (random <= (currentPriceProb += currentPrice.getProbability()))) {
                thePrice = currentPrice;
                break;
            }
        }
        LuckyWheelPriceDTO priceDTO = new LuckyWheelPriceDTO();
        priceDTO.setPrice(thePrice.getPrice());
        priceDTO.setDisplayText(thePrice.getDisplayText());
        priceDTO.setProbability(thePrice.getProbability());

        Player unluckyPlayer = new Player(9999, 0, 0, 0, "error");
        switch (priceDTO.getPrice()) {
            case "winProgress:game":
                winProgressGame();
                break;
            case "loseHealth:player":
                loseHealthPlayer(playerId);
                break;
            case "winArmor:all":
                winArmorAll();
                break;
            case "loseFood:player":
                loseFoodPlayer(playerId);
                break;
            case "winHealth:player":
                winHealthPlayer(playerId);
                break;
            case "loseFood:all":
                loseFoodAll();
                break;
            case "winFullPoints:player":
                winFullPointsPlayer(playerId);
                break;
            case "loseProgress:game":
                loseProgressGame();
                break;
            case "winArmor:player":
                winArmorPlayer(playerId);
                break;
            case "loseHealth:all":
                loseHealthAll();
                break;
            case "loseHealth:random":
                unluckyPlayer = loseHealthRandom();
                break;
            default:
                break;
        }

        String message =
                p.getName() + " hat am Glücksrad gedreht und hat folgenden Preis gewonnen:\n"
                        + priceDTO.getDisplayText();

        if (priceDTO.getDisplayText().startsWith("Alle")) {
            News news = new News(getCurrentTime(), message);
            NEWS.add(news);
        } else if (priceDTO.getDisplayText().startsWith("Ein")) {
            message =
                    p.getName() + " hat am Glücksrad gedreht und hat folgenden Preis gewonnen:\n"
                            + priceDTO.getDisplayText() + ". Der Pechvogel ist: " + unluckyPlayer.getName();
            News news = new News(getCurrentTime(), message);
            NEWS.add(news);
        }

        Price price = new Price(getCurrentTime(), message);
        PRICE.add(price);

        return "Schau auf den Bildschirm um deinen Preis zu erfahren!";
    }

    private List<LuckyWheelPriceDTO> getPriceArray() {
        ObjectMapper mapper = new ObjectMapper();
        List<LuckyWheelPriceDTO> priceArray = new ArrayList<>();
        for (LuckyWheelPrice price : LuckyWheelPrice.values()) {
            LuckyWheelPriceDTO priceJson = new LuckyWheelPriceDTO();
            priceJson.setPrice(price.getPrice());
            priceJson.setProbability(price.getProbability());
            priceJson.setDisplayText(price.getDisplayText());
            priceArray.add(priceJson);
        }
        return priceArray;
    }
}
