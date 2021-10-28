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
            GAME_RESET,
            LUCKYWHEEL_SPIN
    )),
    P1(Sets.newHashSet(P1_PLAY, LUCKYWHEEL_SPIN)),
    P2(Sets.newHashSet(P2_PLAY, LUCKYWHEEL_SPIN)),
    P3(Sets.newHashSet(P3_PLAY, LUCKYWHEEL_SPIN)),
    P4(Sets.newHashSet(P4_PLAY, LUCKYWHEEL_SPIN)),
    P5(Sets.newHashSet(P5_PLAY, LUCKYWHEEL_SPIN)),
    P6(Sets.newHashSet(P6_PLAY, LUCKYWHEEL_SPIN)),
    P7(Sets.newHashSet(P7_PLAY, LUCKYWHEEL_SPIN)),
    P8(Sets.newHashSet(P8_PLAY, LUCKYWHEEL_SPIN)),
    P9(Sets.newHashSet(P9_PLAY, LUCKYWHEEL_SPIN)),
    P10(Sets.newHashSet(P10_PLAY, LUCKYWHEEL_SPIN)),
    P11(Sets.newHashSet(P11_PLAY, LUCKYWHEEL_SPIN)),
    P12(Sets.newHashSet(P12_PLAY, LUCKYWHEEL_SPIN)),
    P13(Sets.newHashSet(P13_PLAY, LUCKYWHEEL_SPIN)),
    P14(Sets.newHashSet(P14_PLAY, LUCKYWHEEL_SPIN)),
    P15(Sets.newHashSet(P15_PLAY, LUCKYWHEEL_SPIN)),
    P16(Sets.newHashSet(P16_PLAY, LUCKYWHEEL_SPIN)),
    P17(Sets.newHashSet(P17_PLAY, LUCKYWHEEL_SPIN)),
    P18(Sets.newHashSet(P18_PLAY, LUCKYWHEEL_SPIN)),
    P19(Sets.newHashSet(P19_PLAY, LUCKYWHEEL_SPIN)),
    P20(Sets.newHashSet(P20_PLAY, LUCKYWHEEL_SPIN)),
    P21(Sets.newHashSet(P21_PLAY, LUCKYWHEEL_SPIN)),
    P22(Sets.newHashSet(P22_PLAY, LUCKYWHEEL_SPIN)),
    P23(Sets.newHashSet(P23_PLAY, LUCKYWHEEL_SPIN)),
    P24(Sets.newHashSet(P24_PLAY, LUCKYWHEEL_SPIN)),
    P25(Sets.newHashSet(P25_PLAY, LUCKYWHEEL_SPIN)),
    P26(Sets.newHashSet(P26_PLAY, LUCKYWHEEL_SPIN)),
    P27(Sets.newHashSet(P27_PLAY, LUCKYWHEEL_SPIN)),
    P28(Sets.newHashSet(P28_PLAY, LUCKYWHEEL_SPIN)),
    P29(Sets.newHashSet(P29_PLAY, LUCKYWHEEL_SPIN)),
    P30(Sets.newHashSet(P30_PLAY, LUCKYWHEEL_SPIN));

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }
}
