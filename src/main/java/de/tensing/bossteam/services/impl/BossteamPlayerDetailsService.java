package de.tensing.bossteam.services.impl;

import de.tensing.bossteam.repositories.PlayerRepository;
import de.tensing.bossteam.repositories.entities.PlayerEntity;
import de.tensing.bossteam.services.PlayerDetails;
import de.tensing.bossteam.services.PlayerDetailsService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

public class BossteamPlayerDetailsService<UserRepository> implements PlayerDetailsService {

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public PlayerDetails loadPlayerById(Integer id) throws NotFoundException {
        PlayerEntity player = playerRepository.getPlayerById();
        if (player == null) {
            throw new NotFoundException("Could not find a player with that id");
        }

        return new BossteamPlayerDetails(player);
    }
}
