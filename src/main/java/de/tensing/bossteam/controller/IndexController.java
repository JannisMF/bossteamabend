package de.tensing.bossteam.controller;

import de.tensing.bossteam.utils.Request;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

import static de.tensing.bossteam.entities.Game.*;
import static de.tensing.bossteam.entities.Settings.MAX_PROGRESS;
import static de.tensing.bossteam.utils.Request.getServerUrl;
import static de.tensing.bossteam.utils.TimeConverter.secToMinAndSecString;

@RestController
@RequestMapping("/")
public class IndexController {

    @GetMapping()
    public ModelAndView indexPage(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("index");
        computeDayNight();
        mav.addObject("playerList", PLAYERS_LIST);
        mav.addObject("progress", PROGRESS);
        mav.addObject("maxProgress", MAX_PROGRESS);
        mav.addObject("daytime", DAYTIME);
        mav.addObject("time", TIME);
        mav.addObject("news", NEWS);
        mav.addObject("serverUrl", getServerUrl(request));
        return mav;
    }

    private void computeDayNight() {
        if (IS_DAY) {
            DAYTIME = "TAG";
        } else {
            DAYTIME = "NACHT";
        }
        TIME = secToMinAndSecString(TIME_SEC);
    }
}