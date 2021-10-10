package de.tensing.bossteam.player;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@RestController
@RequestMapping("api/v1/player")
public class PlayerController {

    private static final int numberOfPlayers = 30;

    private static final int startHealth = 10;
    private static final int startFood = 10;
    private static final int startArmor = 0;
    private static List<Player> PLAYERS_LIST = new ArrayList<>();

    static {
        IntStream
                .rangeClosed(1, numberOfPlayers)
                .forEach(i -> PLAYERS_LIST
                        .add(new Player(i, startHealth, startFood, startArmor)));
    }

    @GetMapping(path = "{playerId}")
    public Player getPlayer(@PathVariable("playerId") Integer playerId) {
        return PLAYERS_LIST.stream()
                .filter(player -> playerId.equals(player.getPlayerId()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Player " + playerId + " does not exist."));
    }
}