package de.tensing.bossteam.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.tensing.bossteam.entities.LuckyWheelPrice;
import de.tensing.bossteam.entities.Player;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.servlet.ServletContextListener;
import java.io.File;
import java.io.FileReader;
import java.net.URL;

import static de.tensing.bossteam.entities.Game.PLAYERS_LIST;
import static de.tensing.bossteam.entities.Game.WHEEL_SPINNING;

@Controller
@RequestMapping("luckywheel")
public class LuckyWheelController {

    @GetMapping
    public ModelAndView luckwheelPage() {
        ModelAndView mav = new ModelAndView("luckywheel");
        return mav;
    }

    @GetMapping(path = "spinWheel")
    public ModelAndView spinPage() throws JsonProcessingException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String playerUsername = auth.getName();
        Integer playerId = Integer.parseInt(playerUsername);
        Player currentPlayer = PLAYERS_LIST.get(playerId - 1);

        ModelAndView mav = new ModelAndView("spin");
        ObjectMapper mapper = new ObjectMapper();
        String playerJson = mapper.writeValueAsString(currentPlayer);

        mav.addObject("player", playerJson);

        System.out.println(currentPlayer + " | spinPage");
        return mav;
    }

    @PostMapping(path = "spinWheel/spin")
    public @ResponseBody
    String spinWheel(@RequestBody Player p) {
        System.out.println(p + " | spinWheel");
        if (WHEEL_SPINNING) {
            return "Du kannst das Glücksrad nicht drehen während es schon gedreht wird!";
        }
        if (p.getHealth() == 1) {
            return "Du kannst nicht drehen, weil du dich sonst selbst Töten würdest!";
        }
        if (p.getHealth() == 0) {
            return "Du bist noch Tod. Gehe in den Todesraum um Wiederbelebt zu werden!";
        }

        WHEEL_SPINNING = true;
        if (p.getArmor() > 0) {
            p.setArmor(p.getArmor() - 1);
        } else {
            p.setHealth(p.getHealth() - 1);
        }
        PLAYERS_LIST.set(p.getPlayerId() - 1, p);

        int random = (int) (Math.random() * 1000) + 1; // Random num between 1 and 1000.
        LuckyWheelPrice[] allPrices = LuckyWheelPrice.values();
        LuckyWheelPrice thePrice = null;
        int currentPriceProb = 0; // Current Price Probability
        for (LuckyWheelPrice currentPrice : allPrices) {
            if ((random > currentPriceProb) && (random <= (currentPriceProb += currentPrice.getProbability()))) {
                thePrice = currentPrice;
                break;
            }
        }
        if (thePrice == null) {
            return "Oops. Price not found.";
        }
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        try {
            URL url = ServletContextListener.class
                    .getClassLoader().getResource("static/js/luckyWheelAnimation.js");
            File file = new File(url.getPath());
            System.out.println(file);
            engine.eval(new FileReader(file));
            Invocable invocable = (Invocable) engine;
            invocable.invokeFunction("setup", allPrices, thePrice, random);
            return "Glücksrad wird gedreht;";
        } catch (Exception e) {
            e.getStackTrace();
            return "Es ist ein Fehler aufgetreten";
        }
    }
}
