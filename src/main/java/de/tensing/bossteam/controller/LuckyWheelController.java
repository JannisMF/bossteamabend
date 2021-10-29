package de.tensing.bossteam.controller;

import de.tensing.bossteam.entities.Player;
import de.tensing.bossteam.entities.LuckyWheelPrice;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import static de.tensing.bossteam.entities.Game.PLAYERS_LIST;
import static de.tensing.bossteam.entities.Game.WHEEL_SPINNING;

@Controller
@RequestMapping("luckywheel")
public class LuckyWheelController {

    @GetMapping(path = "spinWheel")
    public ModelAndView spinPage() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String playerUsername = auth.getName();
        Integer playerId = Integer.parseInt(playerUsername);
        Player currentPlayer = PLAYERS_LIST.get(playerId - 1);

        ModelAndView mav = new ModelAndView("spin");
        mav.addObject("player", currentPlayer);

        System.out.println(currentPlayer);
        return mav;
    }

    @GetMapping(path = "spinWheel/spin")
    public String spinWheel(Player p) {
        if (WHEEL_SPINNING) {
            return "Du kannst das Glücksrad nicht drehene, während es schon gedreht wird!";
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
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn")
        // TODO: Call JS Method with Script
    }
}
