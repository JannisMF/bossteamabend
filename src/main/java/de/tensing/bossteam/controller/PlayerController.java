package de.tensing.bossteam.controller;

import de.tensing.bossteam.entities.Player;
import de.tensing.bossteam.utils.QrCodeGenerator;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static de.tensing.bossteam.entities.Game.PLAYERS_LIST;
import static de.tensing.bossteam.entities.Settings.*;

@RestController
@RequestMapping("player")
public class PlayerController {

    @GetMapping(path = "{playerId}")
    public ModelAndView playerPage(@PathVariable("playerId") Integer playerId) {
        Player p = PLAYERS_LIST.stream()
                .filter(player -> playerId.equals(player.getPlayerId()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Player " + playerId + " existiert nicht."));
        ModelAndView mav = new ModelAndView("player");
        mav.addObject("playerId", p.getPlayerId());
        mav.addObject("health", p.getHealth());
        mav.addObject("food", p.getFood());
        mav.addObject("armor", p.getArmor());
        return mav;
    }

    @GetMapping(path = "{playerId}/addHealth")
    public String addHealth(@PathVariable("playerId") Integer playerId) {
        Player p = PLAYERS_LIST.get(playerId - 1);
        if (p.getHealth() < 10) {
            p.setHealth(p.getHealth() + 1);
            return "Das Leben von Spieler " + playerId + " wurde auf " + p.getHealth() + " gesetzt.";
        }
        return "Das Leben von Spieler " + playerId + " kann nicht höher als 10 werden.";
    }

    @GetMapping(path = "{playerId}/removeHealth")
    public String removeHealth(@PathVariable("playerId") Integer playerId) {
        Player p = PLAYERS_LIST.get(playerId - 1);
        if (p.getArmor() > 0) {
            p.setArmor(p.getArmor() - 1);
            return "Der Spieler " + playerId + " hat Rüstung. Die Rüstung wurde auf " + p.getArmor() + " gesetzt.";
        } else if (p.getHealth() > 0) {
            p.setHealth(p.getHealth() - 1);
        }
        if (p.getHealth() == 0) {
            return "TOT! Der Spieler " + playerId + " ist gestorben.";
        }
        return "Das Leben von Spieler " + playerId + " wurde auf " + p.getHealth() + " gesetzt.";
    }

    @GetMapping(path = "{playerId}/fillFood")
    public String fillFood(@PathVariable("playerId") Integer playerId) {
        Player p = PLAYERS_LIST.get(playerId - 1);
        if (!(p.getHealth() > 0)) {
            return "Oops! Spieler " + playerId + " ist tot und kann kein Essen erhalten.";
        }
        if (p.getFood() < 10) {
            p.setFood(10);
            return "Das Essen von Spieler " + playerId + " wurde auf wieder aufgefüllt.";
        }
        return "Das Essen von Spieler " + playerId + " ist bereits aufgefüllt.";
    }

    @GetMapping(path = "{playerId}/removeFood")
    public String removeFood(@PathVariable("playerId") Integer playerId) {
        Player p = PLAYERS_LIST.get(playerId - 1);
        if (p.getFood() > 0) {
            p.setFood(p.getFood() - 1);
            return "Das Essen von Spieler " + playerId + " wurde auf " + p.getFood() + " gesetzt.";
        } else if (p.getFood() == 0) {
            if (p.getHealth() > 0) {
                p.setHealth(p.getHealth() - 1);
            }
            if (p.getHealth() == 0) {
                return "TOT! Der Spieler " + playerId + " ist gestorben.";
            }
        }
        return "Spieler " + playerId + " hat kein Essen mehr. Das Leben wurde auf " + p.getHealth() + " gesetzt.";
    }

    @GetMapping(path = "{playerId}/addArmor")
    public String addArmor(@PathVariable("playerId") Integer playerId) {
        Player p = PLAYERS_LIST.get(playerId - 1);
        if (!(p.getHealth() > 0)) {
            return "Oops! Spieler " + playerId + " ist tot und kann keine Rüstung erhalten.";
        } else if (p.getArmor() < 10) {
            p.setArmor(p.getArmor() + 1);
            return "Die Rüstung von Spieler " + playerId + " wurde auf " + p.getArmor() + " gesetzt.";
        }
        return "Die Rüstung von Spieler " + playerId + " kann nicht höher als 10 werden.";
    }

    @GetMapping(path = "{playerId}/respawnPlayer")
    public String respawnPlayer(@PathVariable("playerId") Integer playerId) {
        Player p = PLAYERS_LIST.get(playerId - 1);
        if (p.getHealth() > 0) {
            return "Oops! Spieler " + playerId + " ist am Leben. Lebendige können nicht Wiederbelebt werden.";
        } else {
            p.setHealth(RESPAWN_HEALTH);
            p.setFood(RESPAWN_FOOD);
            p.setArmor(RESPAWN_ARMOR);
            return "Respawned! Spieler " + playerId + " ist nun wieder lebendig.";
        }
    }

    @GetMapping(path = "{playerId}/qrCode", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] generateQrCode(@PathVariable("playerId") Integer playerId) throws IOException {
        if (playerId <= 0 || playerId > PLAYERS_LIST.size()) {
            throw new IllegalArgumentException("Invalid player id");
        }

        String url = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/..").build().normalize().toString();
        BufferedImage image = QrCodeGenerator.generateQrCodeFrom(url, 400, 400);

        ByteArrayOutputStream bao = new ByteArrayOutputStream();
        ImageIO.write(image, "jpg", bao);
        return bao.toByteArray();
    }

}