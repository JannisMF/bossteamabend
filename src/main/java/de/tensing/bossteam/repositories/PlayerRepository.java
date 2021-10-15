package de.tensing.bossteam.repositories;

import de.tensing.bossteam.repositories.entities.PlayerEntity;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository<PlayerEntity, Integer> {

    public PlayerEntity getPlayerById();
}
