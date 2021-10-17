package de.tensing.bossteam.controller;

import de.tensing.bossteam.entities.Game;
import de.tensing.bossteam.settings.Settings;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import static de.tensing.bossteam.entities.Game.PROGRESS;
import static de.tensing.bossteam.settings.Settings.MAX_PROGRESS;

@RestController
@RequestMapping("game")
public class GameController {

    @GetMapping(path = "/settings")
    public ModelAndView settingsPage() {
        ModelAndView mav = new ModelAndView("settings");
        return mav;
    }

    public void addProgress() {
        if (PROGRESS < MAX_PROGRESS) {
            PROGRESS++;
        } else {
            // TODO: SPIEL FERTIG
        }
    }

    public void removeProgress() {
        if (PROGRESS > 0) {
            PROGRESS--;
        }
    }
}