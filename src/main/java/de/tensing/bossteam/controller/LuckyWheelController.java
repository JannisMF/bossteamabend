package de.tensing.bossteam.controller;

import de.tensing.bossteam.entities.Player;
import de.tensing.bossteam.entities.LuckyWheelPrice;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import static de.tensing.bossteam.entities.Game.PLAYERS_LIST;

@Controller
@RequestMapping("luckywheel")
public class LuckyWheelController {

    @GetMapping()
    public ModelAndView wheelPage() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String playerUsername = auth.getName();
        Integer playerId = Integer.parseInt(playerUsername);
        Player currentPlayer = PLAYERS_LIST.get(playerId - 1);

        ModelAndView mav = new ModelAndView("spin");
        mav.addObject("player", currentPlayer);

        System.out.println(currentPlayer);
        return mav;
    }

    @GetMapping(path = "spin")
    public void spinWheel() {
        int random = (int) (Math.random() * 1000) + 1; // Random num between 1 and 1000.
        LuckyWheelPrice[] allPrices = LuckyWheelPrice.values();
        String thePrice = null;
        int currentPriceProb = 0; // Current Price Probability
        for (LuckyWheelPrice currentPrice : allPrices) {
            if ((random > currentPriceProb) && (random <= (currentPriceProb += currentPrice.getProbability()))) {
                thePrice = currentPrice.getPrice();
                break;
            }
        }
        // TODO: Call JS Method with Script
    }
}
