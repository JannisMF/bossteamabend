package de.tensing.bossteam.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import static de.tensing.bossteam.entities.Game.PLAYERS_LIST;
import static de.tensing.bossteam.entities.Game.PROGRESS;
import static de.tensing.bossteam.entities.Settings.MAX_PROGRESS;

@RestController
@RequestMapping("/")
public class IndexController {

    @GetMapping()
    public ModelAndView indexPage() {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("playerList", PLAYERS_LIST);
        mav.addObject("progress", PROGRESS);
        mav.addObject("maxProgress", MAX_PROGRESS);
        return mav;
    }
}