package de.tensing.bossteam.security;

public enum ApplicationUserPermission {
    PLAYER_READ("player:read"),
    PLAYER_WRITE("player:write"),
    GAME_START("game:start"),
    GAME_RESET("game:reset");

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
