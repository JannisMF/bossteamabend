package de.tensing.bossteam.player;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<PlayerDTO, Integer> {
}
