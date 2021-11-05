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
    )),
    P1(Sets.newHashSet(P1_PLAY)),
    P2(Sets.newHashSet(P2_PLAY)),
    P3(Sets.newHashSet(P3_PLAY)),
    P4(Sets.newHashSet(P4_PLAY)),
    P5(Sets.newHashSet(P5_PLAY)),
    P6(Sets.newHashSet(P6_PLAY)),
    P7(Sets.newHashSet(P7_PLAY)),
    P8(Sets.newHashSet(P8_PLAY)),
    P9(Sets.newHashSet(P9_PLAY)),
    P10(Sets.newHashSet(P10_PLAY)),
    P11(Sets.newHashSet(P11_PLAY)),
    P12(Sets.newHashSet(P12_PLAY)),
    P13(Sets.newHashSet(P13_PLAY)),
    P14(Sets.newHashSet(P14_PLAY)),
    P15(Sets.newHashSet(P15_PLAY)),
    P16(Sets.newHashSet(P16_PLAY)),
    P17(Sets.newHashSet(P17_PLAY)),
    P18(Sets.newHashSet(P18_PLAY)),
    P19(Sets.newHashSet(P19_PLAY)),
    P20(Sets.newHashSet(P20_PLAY)),
    P21(Sets.newHashSet(P21_PLAY)),
    P22(Sets.newHashSet(P22_PLAY)),
    P23(Sets.newHashSet(P23_PLAY)),
    P24(Sets.newHashSet(P24_PLAY)),
    P25(Sets.newHashSet(P25_PLAY)),
    P26(Sets.newHashSet(P26_PLAY)),
    P27(Sets.newHashSet(P27_PLAY)),
    P28(Sets.newHashSet(P28_PLAY)),
    P29(Sets.newHashSet(P29_PLAY)),
    P30(Sets.newHashSet(P30_PLAY));

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }
}
