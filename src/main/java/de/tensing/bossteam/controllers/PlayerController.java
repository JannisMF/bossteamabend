package de.tensing.bossteam.controllers;

import de.tensing.bossteam.controllers.mapper.PlayerDTOMapper;
import de.tensing.bossteam.repositories.entities.PlayerEntity;
import de.tensing.bossteam.services.PlayerDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("player")
public class PlayerController {

    private final PlayerDetailsService playerService;
    private final PlayerDTOMapper mapper;

    public PlayerController(PlayerDetailsService playerService, PlayerDTOMapper mapper) {
        this.playerService = playerService;
        this.mapper = mapper;
    }

    @GetMapping(path = "/{id}")
    public PlayerEntity getPlayer(@PathVariable("id") Integer playerId) {
    }

    // TODO: Add hasRole for Security.
    @GetMapping(path = "{playerId}")
    public void addHealth(@PathVariable("playerId") Integer playerId) {
        PlayerEntity player = playerRepository.findById(playerId)
                .orElseThrow(() -> new IllegalStateException("Player " + playerId + " does not exist."));
        if (player.getHealth() < 10) {
            player.setHealth(player.getHealth() + 1);
            playerRepository.save(player);
        }
    }

    @GetMapping(path = "{playerId}")
    public void removeHealth(@PathVariable("playerId") Integer playerId) {
        PlayerEntity player = playerRepository.findById(playerId)
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

    @GetMapping(path = "{playerId}")
    public void addFood(@PathVariable("playerId") Integer playerId) {
        PlayerEntity player = playerRepository.findById(playerId)
                .orElseThrow(() -> new IllegalStateException("Player " + playerId + " does not exist."));
        if (player.getFood() < 10) {
            player.setFood(player.getFood() + 1);
            playerRepository.save(player);
        }
    }

    @GetMapping(path = "{playerId}")
    public void removeFood(@PathVariable("playerId") Integer playerId) {
        PlayerEntity player = playerRepository.findById(playerId)
                .orElseThrow(() -> new IllegalStateException("Player " + playerId + " does not exist."));
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
        playerRepository.save(player);
    }

    @GetMapping(path = "{playerId}")
    public void addArmor(@PathVariable("playerId") Integer playerId) {
        PlayerEntity player = playerRepository.findById(playerId)
                .orElseThrow(() -> new IllegalStateException("Player " + playerId + " does not exist."));
        if (player.getArmor() < 10) {
            player.setArmor(player.getArmor() + 1);
            playerRepository.save(player);
        }
    }
}