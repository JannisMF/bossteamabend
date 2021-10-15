package de.tensing.bossteam.services;

import java.util.Collection;

public interface PlayerDetails {

    public Integer getId();

    public Integer getHealth();

    public Integer getFood();

    public Integer getArmor();

    public Collection<?> getPermissions();
}
