package de.tensing.bossteam.security;

public enum ApplicationUserPermission {
    PLAYER_READ("player:read"),
    PLAYER_WRITE("player:write"),
    GAME_START("game:start"),
    GAME_RESET("game:reset"),
    P1_PLAY("p1:play"),
    P2_PLAY("p2:play"),
    P3_PLAY("p3:play"),
    P4_PLAY("p4:play"),
    P5_PLAY("p5:play"),
    P6_PLAY("p6:play"),
    P7_PLAY("p7:play"),
    P8_PLAY("p8:play"),
    P9_PLAY("p9:play"),
    P10_PLAY("p10:play"),
    P11_PLAY("p11:play"),
    P12_PLAY("p12:play"),
    P13_PLAY("p13:play"),
    P14_PLAY("p14:play"),
    P15_PLAY("p15:play"),
    P16_PLAY("p16:play"),
    P17_PLAY("p17:play"),
    P18_PLAY("p18:play"),
    P19_PLAY("p19:play"),
    P20_PLAY("p20:play"),
    P21_PLAY("p21:play"),
    P22_PLAY("p22:play"),
    P23_PLAY("p23:play"),
    P24_PLAY("p24:play"),
    P25_PLAY("p25:play"),
    P26_PLAY("p26:play"),
    P27_PLAY("p27:play"),
    P28_PLAY("p28:play"),
    P29_PLAY("p29:play"),
    P30_PLAY("p30:play"),
    LUCKYWHEEL_SPIN("luckywheel:spin");

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
