package de.tensing.bossteam.controller;

import de.tensing.bossteam.entities.NumberOfPlayersDTO;
import de.tensing.bossteam.entities.Settings;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static de.tensing.bossteam.entities.Game.*;
import static de.tensing.bossteam.entities.Settings.*;

@Slf4j
@RestController
@RequestMapping("game")
public class GameController {

    @GetMapping(path = "settings")
    public ModelAndView settingsPage() {
        ModelAndView mav = new ModelAndView("settings");
        mav.addObject("playerList", PLAYERS_LIST);
        mav.addObject("numberOfPlayer", NUMBER_OF_PLAYERS);
        mav.addObject("maxProgress", MAX_PROGRESS);
        return mav;
    }

    @PostMapping(value = "settings/startGame",
            produces = "application/json",
            consumes = "application/json")
    public String startGame(@RequestBody NumberOfPlayersDTO numberOfPlayersDTO) {
        NUMBER_OF_PLAYERS = Integer.parseInt(numberOfPlayersDTO.getNumberOfPlayers());
        GAME_STARTED = true;

        // Remove Players from PLAYERS_LIST
        for (int i = NUMBER_OF_PLAYERS - 1; i < PLAYERS_LIST.toArray().length; i++) {
            PLAYERS_LIST.remove(i);
        }

        return "Spiel gestartet";
    }

    @GetMapping(path = "progress")
    public ModelAndView progressPage() {
        ModelAndView mav = new ModelAndView("progress");
        mav.addObject("playerList", PLAYERS_LIST);
        mav.addObject("progress", PROGRESS);
        mav.addObject("maxProgress", MAX_PROGRESS);
        return mav;
    }

    @GetMapping(path = "progress/addProgress")
    public String addProgress() {
        if (PROGRESS < MAX_PROGRESS) {
            PROGRESS++;
            return "Der Fortschritt beträgt nun " + PROGRESS + ".";
        } else {
            return "Das Spiel ist vorbei!";
        }
    }

    @GetMapping(path = "progress/removeProgress")
    public String removeProgress() {
        if (PROGRESS > 0) {
            PROGRESS--;
            return "Der Fortschritt beträgt nun " + PROGRESS + ".";
        }
        return "Der Fortschritt kann nicht weniger als 0 sein.";
    }
}