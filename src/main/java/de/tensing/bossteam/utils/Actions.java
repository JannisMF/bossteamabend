package de.tensing.bossteam.utils;

import de.tensing.bossteam.entities.Player;

import static de.tensing.bossteam.entities.Game.PLAYERS_LIST;
import static de.tensing.bossteam.entities.Game.PROGRESS;
import static de.tensing.bossteam.entities.Settings.*;

public class Actions {
    public static String addHealth(Integer playerId) {
        Player p = PLAYERS_LIST.get(playerId - 1);
        if (p.getHealth() < 10) {
            p.setHealth(p.getHealth() + 1);
            return "Das Leben von Spieler " + playerId + " wurde auf " + p.getHealth() + " gesetzt.";
        }
        return "Das Leben von Spieler " + playerId + " kann nicht höher als 10 werden.";
    }

    public static String removeHealth(Integer playerId) {
        Player p = PLAYERS_LIST.get(playerId - 1);
        if (p.getArmor() > 0) {
            p.setArmor(p.getArmor() - 1);
            return "Der Spieler " + playerId + " hat Rüstung. Die Rüstung wurde auf " + p.getArmor() + " gesetzt.";
        } else if (p.getHealth() > 0) {
            p.setHealth(p.getHealth() - 1);
        }
        if (p.getHealth() == 0) {
            return "TOT! Der Spieler " + playerId + " ist gestorben.";
        }
        return "Das Leben von Spieler " + playerId + " wurde auf " + p.getHealth() + " gesetzt.";
    }

    public static String fillFood(Integer playerId) {
        Player p = PLAYERS_LIST.get(playerId - 1);
        if (!(p.getHealth() > 0)) {
            return "Oops! Spieler " + playerId + " ist tot und kann kein Essen erhalten.";
        }
        if (p.getFood() < 10) {
            p.setFood(10);
            return "Das Essen von Spieler " + playerId + " wurde auf wieder aufgefüllt.";
        }
        return "Das Essen von Spieler " + playerId + " ist bereits aufgefüllt.";
    }

    public static String removeFood(Integer playerId) {
        Player p = PLAYERS_LIST.get(playerId - 1);
        if (p.getFood() > 0) {
            p.setFood(p.getFood() - 1);
            return "Das Essen von Spieler " + playerId + " wurde auf " + p.getFood() + " gesetzt.";
        } else if (p.getFood() == 0) {
            if (p.getHealth() > 0) {
                p.setHealth(p.getHealth() - 1);
            }
            if (p.getHealth() == 0) {
                return "TOT! Der Spieler " + playerId + " ist gestorben.";
            }
        }
        return "Spieler " + playerId + " hat kein Essen mehr. Das Leben wurde auf " + p.getHealth() + " gesetzt.";
    }

    public static String addArmor(Integer playerId) {
        Player p = PLAYERS_LIST.get(playerId - 1);
        if (!(p.getHealth() > 0)) {
            return "Oops! Spieler " + playerId + " ist tot und kann keine Rüstung erhalten.";
        } else if (p.getArmor() < 10) {
            p.setArmor(p.getArmor() + 1);
            return "Die Rüstung von Spieler " + playerId + " wurde auf " + p.getArmor() + " gesetzt.";
        }
        return "Die Rüstung von Spieler " + playerId + " kann nicht höher als 10 werden.";
    }

    public static String respawnPlayer(Integer playerId) {
        Player p = PLAYERS_LIST.get(playerId - 1);
        if (p.getHealth() > 0) {
            return "Oops! Spieler " + playerId + " ist am Leben. Lebendige können nicht Wiederbelebt werden.";
        } else {
            p.setHealth(RESPAWN_HEALTH);
            p.setFood(RESPAWN_FOOD);
            p.setArmor(RESPAWN_ARMOR);
            return "Respawned! Spieler " + playerId + " ist nun wieder lebendig.";
        }
    }

    public static String addProgress() {
        if (PROGRESS < MAX_PROGRESS) {
            PROGRESS++;
            return "Der Fortschritt beträgt nun " + PROGRESS + ".";
        } else {
            return "Das Spiel ist vorbei!";
        }
    }

    public static String removeProgress() {
        if (PROGRESS > 0) {
            PROGRESS--;
            return "Der Fortschritt beträgt nun " + PROGRESS + ".";
        }
        return "Der Fortschritt kann nicht weniger als 0 sein.";
    }

    public static String removeFoodNoHealth(Integer playerId) {
        Player p = PLAYERS_LIST.get(playerId - 1);
        if (p.getFood() > 0) {
            p.setFood(p.getFood() - 1);
            return "Das Essen von Spieler " + playerId + " wurde auf " + p.getFood() + " gesetzt.";
        }
        return "Spieler " + playerId + " hat kein Essen mehr.";
    }
}
