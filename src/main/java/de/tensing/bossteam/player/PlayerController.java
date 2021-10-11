package de.tensing.bossteam.player;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@RestController
@RequestMapping("player")
public class PlayerController {

    private static final int numberOfPlayers = 30;

    private static final int startHealth = 10;
    private static final int startFood = 10;
    private static final int startArmor = 0;
    private static List<PlayerDTO> PLAYERS_LIST = new ArrayList<>();

    private PlayerRepository playerRepository;

    static {
        IntStream
                .rangeClosed(1, numberOfPlayers)
                .forEach(i -> PLAYERS_LIST
                        .add(new PlayerDTO(i, startHealth, startFood, startArmor)));
    }

    @GetMapping(path = "{playerId}")
    public PlayerDTO getPlayer(@PathVariable("playerId") Integer playerId) {
        return PLAYERS_LIST.stream()
                .filter(player -> playerId.equals(player.getPlayerId()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Player " + playerId + " does not exist."));
    }

    // TODO: Add hasRole for Security.
    @GetMapping(path="{playerId}")
    public void addHealth(@PathVariable("playerId") Integer playerId) {
        PlayerDTO player = playerRepository.findById(playerId)
                .orElseThrow(() -> new IllegalStateException("Player " + playerId + " does not exist."));
        if (player.getHealth() < 10) {
            player.setHealth(player.getHealth() + 1);
            playerRepository.save(player);
        }
    }

    @GetMapping(path="{playerId}")
    public void removeHealth(@PathVariable("playerId") Integer playerId) {
        PlayerDTO player = playerRepository.findById(playerId)
                .orElseThrow(() -> new IllegalStateException("Player " + playerId + " does not exist."));
        if (player.getArmor() > 0) {
            player.setArmor(player.getArmor() - 1);
        } else if (player.getHealth() > 0) {
            player.setHealth(player.getHealth() - 1);
        }

        if (player.getHealth() == 0) {
            // TODO: Spieler ist Tod
        }
        playerRepository.save(player);
    }

    @GetMapping(path="{playerId}")
    public void addFood(@PathVariable("playerId") Integer playerId) {
        PlayerDTO player = playerRepository.findById(playerId)
                .orElseThrow(() -> new IllegalStateException("Player " + playerId + " does not exist."));
        if (player.getFood() < 10) {
            player.setFood(player.getFood() + 1);
            playerRepository.save(player);
        }
    }

    @GetMapping(path="{playerId}")
    public void removeFood(@PathVariable("playerId") Integer playerId) {
        PlayerDTO player = playerRepository.findById(playerId)
                .orElseThrow(() -> new IllegalStateException("Player " + playerId + " does not exist."));
        if (player.getFood() > 0) {
            player.setFood(player.getFood() - 1);
        } else if (player.getFood() == 0) {
            if (player.getFood() > 0) {
                player.setFood(player.getFood() - 1);
            }
            if(player.getFood() == 0) {
                // TODO: Spieler ist Tod.
            }
        }
        playerRepository.save(player);
    }

    @GetMapping(path="{playerId}")
    public void addArmor(@PathVariable("playerId") Integer playerId) {
        PlayerDTO player = playerRepository.findById(playerId)
                .orElseThrow(() -> new IllegalStateException("Player " + playerId + " does not exist."));
        if (player.getArmor() < 10) {
            player.setArmor(player.getArmor() + 1);
            playerRepository.save(player);
        }
    }
}