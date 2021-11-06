package de.tensing.bossteam.controller;

import de.tensing.bossteam.entities.Player;
import de.tensing.bossteam.entities.dtos.NameDTO;
import de.tensing.bossteam.utils.Actions;
import de.tensing.bossteam.utils.QrCodeGenerator;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static de.tensing.bossteam.entities.Game.PLAYERS_LIST;
import static de.tensing.bossteam.utils.Request.getServerUrl;

@RestController
@RequestMapping("player")
public class PlayerController {

    @GetMapping(path = "{playerId}")
    public ModelAndView playerPage(@PathVariable("playerId") Integer playerId, HttpServletRequest request) {
        Player p = PLAYERS_LIST.stream()
                .filter(player -> playerId.equals(player.getPlayerId()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Player " + playerId + " existiert nicht."));
        ModelAndView mav = new ModelAndView("player");
        mav.addObject("playerId", p.getPlayerId());
        mav.addObject("health", p.getHealth());
        mav.addObject("food", p.getFood());
        mav.addObject("armor", p.getArmor());
        mav.addObject("name", p.getName());
        mav.addObject("serverUrl", getServerUrl(request));
        return mav;
    }

    @GetMapping(path = "rename")
    public ModelAndView renamePage(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("rename");
        mav.addObject("serverUrl", getServerUrl(request));
        return mav;
    }

    @PostMapping(value = "rename/changeName",
            produces = "application/json",
            consumes = "application/json")
    public String changeName(@RequestBody NameDTO nameDTO) {
        ModelAndView mav = new ModelAndView("spin");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String playerUsername = auth.getName();
        Integer playerId = Integer.parseInt(playerUsername);
        Player p = PLAYERS_LIST.get(playerId - 1);

        String newName = nameDTO.getName();

        if (newName.length() > 12) {
            return "Dein Name darf Maximal 12 Zeichen lang sein";
        }

        p.setName(newName);

        return "Name geändert!";
    }


    @GetMapping(path = "{playerId}/addHealth")
    public String addHealth(@PathVariable("playerId") Integer playerId) {
        return Actions.addHealth(playerId);
    }

    @GetMapping(path = "{playerId}/removeHealth")
    public String removeHealth(@PathVariable("playerId") Integer playerId) {
        return Actions.removeHealth(playerId);
    }

    @GetMapping(path = "{playerId}/fillFood")
    public String fillFood(@PathVariable("playerId") Integer playerId) {
        return Actions.fillFood(playerId);
    }

    @GetMapping(path = "{playerId}/removeFood")
    public String removeFood(@PathVariable("playerId") Integer playerId) {
        return Actions.removeFood(playerId);
    }

    @GetMapping(path = "{playerId}/addArmor")
    public String addArmor(@PathVariable("playerId") Integer playerId) {
        return Actions.addArmor(playerId);
    }

    @GetMapping(path = "{playerId}/respawnPlayer")
    public String respawnPlayer(@PathVariable("playerId") Integer playerId) {
        return Actions.respawnPlayer(playerId);
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