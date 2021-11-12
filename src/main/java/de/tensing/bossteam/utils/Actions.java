package de.tensing.bossteam.utils;

import de.tensing.bossteam.entities.News;
import de.tensing.bossteam.entities.Player;

import static de.tensing.bossteam.entities.Game.*;
import static de.tensing.bossteam.entities.Settings.*;
import static de.tensing.bossteam.utils.TimeConverter.getCurrentTime;

public class Actions {
    public static String addHealth(Integer playerId) {
        Player p = PLAYERS_LIST.get(playerId - 1);
        if (p.getHealth() < 10) {
            p.setHealth(p.getHealth() + 1);
            return "Das Leben von " + p.getName() + " wurde auf " + p.getHealth() + " gesetzt.";
        }
        return "Das Leben von " + p.getName() + " kann nicht höher als 10 werden.";
    }

    public static String removeHealth(Integer playerId) {
        Player p = PLAYERS_LIST.get(playerId - 1);
        if (p.getArmor() > 0) {
            p.setArmor(p.getArmor() - 1);
            return p.getName() + " hat noch Rüstung. Die Rüstung wurde auf " + p.getArmor() + " gesetzt.";
        } else if (p.getHealth() > 0) {
            p.setHealth(p.getHealth() - 1);
        }
        if (p.getHealth() == 0) {
            String message = "TOT! " + p.getName() + " ist gestorben.";
            News news = new News(getCurrentTime(), message);
            NEWS.add(news);
            return message;
        }
        return "Das Leben von " + p.getName() + " wurde auf " + p.getHealth() + " gesetzt.";
    }

    public static String fillFood(Integer playerId) {
        Player p = PLAYERS_LIST.get(playerId - 1);
        if (!(p.getHealth() > 0)) {
            return "Oops! " + p.getName() + " ist tot und kann kein Essen erhalten.";
        }
        if (p.getFood() < 10) {
            p.setFood(10);
            return "Das Essen von " + p.getName() + " wurde auf wieder aufgefüllt.";
        }
        return "Das Essen von " + p.getName() + " ist bereits aufgefüllt.";
    }

    public static String removeFood(Integer playerId) {
        Player p = PLAYERS_LIST.get(playerId - 1);
        if (p.getFood() > 0) {
            p.setFood(p.getFood() - 1);
            return "Das Essen von " + p.getName() + " wurde auf " + p.getFood() + " gesetzt.";
        } else if (p.getFood() == 0) {
            if (p.getHealth() > 0) {
                p.setHealth(p.getHealth() - 1);
            }
            if (p.getHealth() == 0) {
                String message = "TOT! " + p.getName() + " ist gestorben.";
                News news = new News(getCurrentTime(), message);
                NEWS.add(news);
                return message;
            }
        }
        return p.getName() + " hat kein Essen mehr. Das Leben wurde auf " + p.getHealth() + " gesetzt.";
    }

    public static String addArmor(Integer playerId) {
        Player p = PLAYERS_LIST.get(playerId - 1);
        if (!(p.getHealth() > 0)) {
            return "Oops! " + p.getName() + " ist tot und kann keine Rüstung erhalten.";
        } else if (p.getArmor() < 10) {
            p.setArmor(p.getArmor() + 1);
            return "Die Rüstung von " + p.getName() + " wurde auf " + p.getArmor() + " gesetzt.";
        }
        return "Die Rüstung von " + p.getName() + " kann nicht höher als 10 werden.";
    }

    public static String respawnPlayer(Integer playerId) {
        Player p = PLAYERS_LIST.get(playerId - 1);
        if (p.getHealth() > 0) {
            return "Oops! " + p.getName() + " ist am Leben. Lebendige können nicht wiederbelebt werden.";
        } else {
            p.setHealth(RESPAWN_HEALTH);
            p.setFood(RESPAWN_FOOD);
            p.setArmor(RESPAWN_ARMOR);
            String message = "Respawned! " + p.getName() + " ist nun wieder lebendig.";
            News news = new News(getCurrentTime(), message);
            NEWS.add(news);
            return message;
        }
    }

    public static String addProgress() {
        if (PROGRESS < MAX_PROGRESS) {
            PROGRESS++;
            return "Der Fortschritt beträgt nun " + PROGRESS + ".";
        } else {
            String message = "Das Spiel ist vorbei!";
            News news = new News(getCurrentTime(), message);
            for (int i = 0; i < 20; i++) {
                NEWS.add(news);
            }
            GAME_STARTED = false;
            return message;
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
            return "Das Essen von " + p.getName() + " wurde auf " + p.getFood() + " gesetzt.";
        }
        return p.getName() + " hat kein Essen mehr.";
    }
}
