package de.tensing.bossteam.controller;

import com.vaadin.flow.component.ClientCallable;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;
import de.tensing.bossteam.entities.Player;
import org.checkerframework.checker.units.qual.C;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.websocket.ClientEndpoint;

import static de.tensing.bossteam.entities.Game.PLAYERS_LIST;

@RestController
@RequestMapping("player")
public class PlayerController extends Div {

    @GetMapping(path = "{playerId}")
    public ModelAndView playerPage(@PathVariable("playerId") Integer playerId) {
        Player p = PLAYERS_LIST.stream()
                .filter(player -> playerId.equals(player.getPlayerId()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Player " + playerId + " does not exist."));
        ModelAndView mav = new ModelAndView("player");
        mav.addObject("playerId", "Spieler " + p.getPlayerId());
        mav.addObject("health", "Leben: " + p.getHealth());
        mav.addObject("food", "Essen: " + p.getFood());
        mav.addObject("armor", "Armor: " + p.getArmor());
        return mav;
    }

    public void addHealth(String playerIdString) {
        Player player = PLAYERS_LIST.get(getIntOfString(playerIdString) - 1);
        if (player.getHealth() < 10) {
            player.setHealth(player.getHealth() + 1);
        }
    }

    public void removeHealth(String playerIdString) {
        Player player = PLAYERS_LIST.get(getIntOfString(playerIdString) - 1);
        if (player.getArmor() > 0) {
            player.setArmor(player.getArmor() - 1);
        } else if (player.getHealth() > 0) {
            player.setHealth(player.getHealth() - 1);
        }

        if (player.getHealth() == 0) {
            // TODO: Spieler ist Tod
        }
    }

    public void fillFood(String playerIdString) {
        Player player = PLAYERS_LIST.get(getIntOfString(playerIdString) - 1);
        if (player.getFood() < 10) {
            player.setFood(player.getFood() + 1);
        }
    }

    public void removeFood(String playerIdString) {
        Player player = PLAYERS_LIST.get(getIntOfString(playerIdString) - 1);
        if (player.getFood() > 0) {
            player.setFood(player.getFood() - 1);
        } else if (player.getFood() == 0) {
            if (player.getFood() > 0) {
                player.setFood(player.getFood() - 1);
            }
            if (player.getFood() == 0) {
                // TODO: Spieler ist Tod.
            }
        }
    }

    public void addArmor(String playerIdString) {
        Player player = PLAYERS_LIST.get(getIntOfString(playerIdString) - 1);
        if (player.getArmor() < 10) {
            player.setArmor(player.getArmor() + 1);
        }
    }

    private Integer getIntOfString(String s) {
        String[] split = s.split(" ");
        return Integer.getInteger(split[1]);
    }
}