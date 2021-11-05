package de.tensing.bossteam.utils;

import de.tensing.bossteam.entities.Player;

import static de.tensing.bossteam.entities.Game.PLAYERS_LIST;

public class LuckyWheelActions {

    public static void winProgressGame() {
        Actions.addProgress();
    }

    public static void loseHealthPlayer(Integer playerId) {
        Player p = PLAYERS_LIST.get(playerId - 1);
        Actions.removeHealth(p.getPlayerId());
        Actions.removeHealth(p.getPlayerId());
        Actions.removeHealth(p.getPlayerId());
    }

    public static void winArmorAll() {
        for (Player p : PLAYERS_LIST) {
            Actions.addArmor(p.getPlayerId());
        }
    }

    public static void loseFoodPlayer(Integer playerId) {
        int playerIndex = playerId - 1;
        Player p = PLAYERS_LIST.get(playerIndex);
        p.setFood(0);
    }

    public static void winHealthPlayer(Integer playerId) {
        int playerIndex = playerId - 1;
        Player p = PLAYERS_LIST.get(playerIndex);
        p.setHealth(10);
    }

    public static void loseFoodAll() {
        for (Player p : PLAYERS_LIST) {
            Actions.removeFoodNoHealth(p.getPlayerId());
            Actions.removeFoodNoHealth(p.getPlayerId());
            Actions.removeFoodNoHealth(p.getPlayerId());
        }
    }

    public static void winFullPointsPlayer(Integer playerId) {
        Player p = PLAYERS_LIST.get(playerId - 1);
        p.setHealth(10);
        p.setFood(10);
        p.setArmor(10);
    }

    public static void loseProgressGame() {
        Actions.removeProgress();
    }

    public static void winArmorPlayer(Integer playerId) {
        Actions.addArmor(playerId);
        Actions.addArmor(playerId);
        Actions.addArmor(playerId);
        Actions.addArmor(playerId);
        Actions.addArmor(playerId);
    }

    public static void loseHealthAll() {
        for (Player p : PLAYERS_LIST) {
            Actions.removeHealth(p.getPlayerId());
        }
    }

    public static Player loseHealthRandom() {
        int random = (int) (Math.random() * PLAYERS_LIST.size()) + 1;
        Actions.removeHealth(random);
        return PLAYERS_LIST.get(random - 1);
    }
}
