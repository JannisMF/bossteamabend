package de.tensing.bossteam.controller;

import de.tensing.bossteam.utils.TimeConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import static de.tensing.bossteam.entities.Game.*;
import static de.tensing.bossteam.entities.Settings.*;
import static de.tensing.bossteam.utils.TimeConverter.secToMinAndSecString;

@RestController
@RequestMapping("/")
public class IndexController {

    @GetMapping()
    public ModelAndView indexPage() {
        ModelAndView mav = new ModelAndView("index");
        computeDayNight();
        mav.addObject("playerList", PLAYERS_LIST);
        mav.addObject("progress", PROGRESS);
        mav.addObject("maxProgress", MAX_PROGRESS);
        mav.addObject("daytime", DAYTIME);
        mav.addObject("time", TIME);
        return mav;
    }

    private void computeDayNight() {
        if (IS_DAY) {
            DAYTIME = "TAG";
            TIME = secToMinAndSecString(DAY_LENGTH);
        } else {
            DAYTIME = "NACHT";
            TIME = secToMinAndSecString(NIGHT_LENGTH);
        }
    }
}