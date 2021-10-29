package de.tensing.bossteam.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static de.tensing.bossteam.entities.Settings.*;

@AllArgsConstructor
@Getter
/**
 * Probability is one out of thousand (.1%)
 */
public enum LuckyWheelPrice {
    WIN_PROGRESS_GAME("winProgress:game", 200, LW_COLOR_WIN,
            "Glückwunsch! Ihr bekommt einen Fortschrittspunkt."),
    LOSE_HEALTH_PLAYER("loseHealth:player", 175, LW_COLOR_LOSE,
            "Glückwunsch! Du verlierst 3 Leben."),
    WIN_ARMOR_ALL("winArmor:all", 50, LW_COLOR_WIN,
            "Glückwunsch! Alle Spieler erhalten einen Rüstungspunkt."),
    LOSE_FOOD_PLAYER("loseFood:player", 100, LW_COLOR_LOSE,
            "Gewonnen! Du verlierst deine gesamten Essenspunkte."),
    WIN_HEALTH_PLAYER("winHealth:player", 50, LW_COLOR_WIN,
            "Glückwunsch! Dein gesamtes Leben wird aufgefüllt."),
    LOSE_FOOD_ALL("loseFood:all", 50, LW_COLOR_LOSE,
            "Glückwunsch! Alle Spieler verlieren 3 Essen."), // NOTICE: Food < 3 does NOT reduce Health!
    WIN_FULL_POINTS_PLAYER("winFullPoints:player", 25, LW_COLOR_WIN,
            "Glückwunsch! Deine Lebens-, Essens- und Rüstungspunkte werden komplett aufgefüllt"),
    BLANK("blank", 200, LW_COLOR_BLANK,
            "Verloren! Du bist leider auf einer Niete gelandet :/"),
    LOSE_PROGRESS_GAME("loseProgress:game", 50, LW_COLOR_LOSE,
            "Glückwunsch! Ihr verliert einen Fortschrittspunkt."),
    WIN_ARMOR_PLAYER("winArmor:player", 50, LW_COLOR_WIN,
            "Glückwunsch! Du gewinnst 5 Rüstung."),
    LOSE_HEALTH_ALL("loseHealth:all", 50, LW_COLOR_LOSE,
            "Glückwunsch! Alle Spieler verlieren 1 Leben.");

    private final String price;
    private final int probability;
    private final String hexColor;
    private final String displayText;

    public String getPrice() {
        return price;
    }


}
