package de.tensing.bossteam.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import static de.tensing.bossteam.entities.Game.PLAYERS_LIST;
import static de.tensing.bossteam.entities.Game.PROGRESS;
import static de.tensing.bossteam.entities.Settings.MAX_PROGRESS;

@RestController
@RequestMapping("game")
public class GameController {

    @GetMapping(path = "/settings")
    public ModelAndView settingsPage() {
        ModelAndView mav = new ModelAndView("settings");
        mav.addObject("playerList", PLAYERS_LIST);
        return mav;
    }

    @GetMapping(path = "/progress")
    public ModelAndView progressPage() {
        ModelAndView mav = new ModelAndView("progress");
        mav.addObject("playerList", PLAYERS_LIST);
        mav.addObject("progress", PROGRESS);
        mav.addObject("maxProgress", MAX_PROGRESS);
        return mav;
    }

    @GetMapping(path = "/progress/addProgress")
    public String addProgress() {
        if (PROGRESS < MAX_PROGRESS) {
            PROGRESS++;
            return "Der Fortschritt beträgt nun " + PROGRESS + ".";
        } else {
            return "Das Spiel ist vorbei!";
        }
    }

    @GetMapping(path = "/progress/removeProgress")
    public String removeProgress() {
        if (PROGRESS > 0) {
            PROGRESS--;
            return "Der Fortschritt beträgt nun " + PROGRESS + ".";
        }
        return "Der Fortschritt kann nicht weniger als 0 sein.";
    }
}