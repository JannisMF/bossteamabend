package de.tensing.bossteam.services;

import javassist.NotFoundException;

public interface PlayerDetailsService {

    public PlayerDetails loadPlayerById(Integer id) throws NotFoundException;
}
