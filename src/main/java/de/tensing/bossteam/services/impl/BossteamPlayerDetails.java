package de.tensing.bossteam.services.impl;

import de.tensing.bossteam.repositories.entities.PlayerEntity;
import de.tensing.bossteam.repositories.entities.RoleEntity;
import de.tensing.bossteam.services.PlayerDetails;
import lombok.AllArgsConstructor;

import java.util.Collection;
import java.util.Set;

@AllArgsConstructor
public class BossteamPlayerDetails implements PlayerDetails {

    private PlayerEntity player;

    @Override
    public Integer getId() {
        return player.getId();
    }

    @Override
    public Integer getHealth() {
        return player.getHealth();
    }

    @Override
    public Integer getFood() {
        return player.getFood();
    }

    @Override
    public Integer getArmor() {
        return player.getArmor();
    }

    @Override
    public Collection<?> getPermissions() {
        Set<RoleEntity> roles = player.getRoles();
        List<>
    }
}
