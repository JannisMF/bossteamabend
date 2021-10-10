package de.tensing.bossteam.security;

import com.google.common.collect.Sets;

import java.util.Set;

import static de.tensing.bossteam.security.ApplicationUserPermission.*;

public enum ApplicationUserRole {
    BOSSTEAMER(Sets.newHashSet(
            PLAYER_READ,
            PLAYER_WRITE
    )),
    ADMIN(Sets.newHashSet(
            PLAYER_READ,
            PLAYER_WRITE,
            GAME_START,
            GAME_RESET
    ));

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }
}
