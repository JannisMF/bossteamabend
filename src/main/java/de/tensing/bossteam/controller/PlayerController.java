package de.tensing.bossteam.controller;

import com.vaadin.flow.component.ClientCallable;
import de.tensing.bossteam.entities.Player;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static de.tensing.bossteam.entities.Game.PLAYERS_LIST;

@RestController
@RequestMapping("player")
public class PlayerController {

    @GetMapping(path = "{playerId}")
    public String getPlayer(@PathVariable("playerId") Integer playerId) {
        /*return PLAYERS_LIST.stream()
                .filter(player -> playerId.equals(player.getPlayerId()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Player " + playerId + " does not exist."));*/
        return "player";
    }

    @ClientCallable
    public void addHealth(@PathVariable("playerId") Integer playerId) {
        Player player = PLAYERS_LIST.get(playerId - 1);
        if (player.getHealth() < 10) {
            player.setHealth(player.getHealth() + 1);
        }
    }
/*
    @GetMapping(path = "{playerId}")
    public void removeHealth(@PathVariable("playerId") Integer playerId) {
        Player player = PLAYERS_LIST.get(playerId - 1);
        if (player.getArmor() > 0) {
            player.setArmor(player.getArmor() - 1);
        } else if (player.getHealth() > 0) {
            player.setHealth(player.getHealth() - 1);
        }

        if (player.getHealth() == 0) {
            // TODO: Spieler ist Tod
        }
    }

    @GetMapping(path = "{playerId}")
    public void addFood(@PathVariable("playerId") Integer playerId) {
        Player player = PLAYERS_LIST.get(playerId - 1);
        if (player.getFood() < 10) {
            player.setFood(player.getFood() + 1);
        }
    }

    @GetMapping(path = "{playerId}")
    public void removeFood(@PathVariable("playerId") Integer playerId) {
        Player player = PLAYERS_LIST.get(playerId - 1);
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

    @GetMapping(path = "{playerId}")
    public void addArmor(@PathVariable("playerId") Integer playerId) {
        Player player = PLAYERS_LIST.get(playerId - 1);
        if (player.getArmor() < 10) {
            player.setArmor(player.getArmor() + 1);
        }
    }*/
}