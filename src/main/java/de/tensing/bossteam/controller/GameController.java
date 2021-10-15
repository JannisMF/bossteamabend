package de.tensing.bossteam.controller;

import de.tensing.bossteam.entities.Game;
import de.tensing.bossteam.settings.Settings;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("game")
public class GameController {

    private Settings settings;

    @GetMapping(path = "/settings")
    public Game getGame() {
        return new Game();
    }
}