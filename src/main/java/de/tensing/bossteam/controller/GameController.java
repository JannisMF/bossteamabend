package de.tensing.bossteam.controller;

import de.tensing.bossteam.entities.News;
import de.tensing.bossteam.entities.dtos.NewsDTO;
import de.tensing.bossteam.entities.dtos.NumberOfPlayersDTO;
import de.tensing.bossteam.utils.Actions;
import de.tensing.bossteam.utils.QrCodeGenerator;
import de.tensing.bossteam.utils.TimeConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static de.tensing.bossteam.entities.Game.*;
import static de.tensing.bossteam.entities.Settings.MAX_PROGRESS;
import static de.tensing.bossteam.entities.Settings.NUMBER_OF_PLAYERS;
import static de.tensing.bossteam.utils.Request.getServerUrl;

@Slf4j
@RestController
@RequestMapping("game")
public class GameController {

    @GetMapping(path = "settings")
    public ModelAndView settingsPage(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("settings");
        mav.addObject("playerList", PLAYERS_LIST);
        mav.addObject("numberOfPlayer", NUMBER_OF_PLAYERS);
        mav.addObject("maxProgress", MAX_PROGRESS);
        mav.addObject("serverUrl", getServerUrl(request));
        return mav;
    }

    @PostMapping(value = "settings/startGame",
            produces = "application/json",
            consumes = "application/json")
    public String startGame(@RequestBody NumberOfPlayersDTO numberOfPlayersDTO) {
        NUMBER_OF_PLAYERS = Integer.parseInt(numberOfPlayersDTO.getNumberOfPlayers());
        GAME_STARTED = true;

        // Remove Players from PLAYERS_LIST
        for (int i = PLAYERS_LIST.size(); i > NUMBER_OF_PLAYERS; i--) {
            PLAYERS_LIST.remove(i - 1);
        }

        return "Spiel gestartet";
    }

    @GetMapping(path = "progress")
    public ModelAndView progressPage(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("progress");
        mav.addObject("playerList", PLAYERS_LIST);
        mav.addObject("progress", PROGRESS);
        mav.addObject("maxProgress", MAX_PROGRESS);
        mav.addObject("serverUrl", getServerUrl(request));
        return mav;
    }

    @GetMapping(path = "progress/addProgress")
    public String addProgress() {
        return Actions.addProgress();
    }

    @GetMapping(path = "progress/removeProgress")
    public String removeProgress() {
        return Actions.removeProgress();
    }

    @PostMapping(value = "progress/sendNews",
            produces = "application/json",
            consumes = "application/json")
    public String startGame(@RequestBody NewsDTO newsDTO) {
        News news = new News(TimeConverter.getCurrentTime(), newsDTO.getMessage());
        NEWS.add(news);

        return "News erschienen!";
    }

    @GetMapping(path = "progress/qrCode", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] generateQrCode() throws IOException {
        String url = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/..").build().normalize().toString();
        BufferedImage image = QrCodeGenerator.generateQrCodeFrom(url, 400, 400);

        ByteArrayOutputStream bao = new ByteArrayOutputStream();
        ImageIO.write(image, "jpg", bao);
        return bao.toByteArray();
    }
}