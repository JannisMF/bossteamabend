package de.tensing.bossteam.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
/**
 * Probability is one out of thousand (.1%)
 */
public enum LuckyWheelPrice {
    LOSE_HEALTH_ALL("loseHealth:all", 50,
            "Glückwunsch! Alle Spieler verlieren 1 Leben."),
    LOSE_HEALTH_PLAYER("loseHealth:player", 175,
            "Glückwunsch! Du verlierst 3 Leben."),
    LOSE_FOOD_ALL("loseFood:all", 50,
            "Glückwunsch! Alle Spieler verlieren 3 Essen."), // NOTICE: Food < 3 does NOT reduce Health!
    LOSE_FOOD_PLAYER("loseFood:player", 100,
            "Gewonnen! Du verlierst deine gesamten Essenspunkte."),
    LOSE_PROGRESS_GAME("loseProgress:game", 50,
            "Glückwunsch! Ihr verliert einen Fortschrittspunkt."),
    WIN_HEALTH_PLAYER("winHealth:player", 50,
            "Glückwunsch! Dein gesamtes Leben wird aufgefüllt."),
    WIN_ARMOR_ALL("winArmor:all", 50,
            "Glückwunsch! Alle Spieler erhalten einen Rüstungspunkt."),
    WIN_ARMOR_PLAYER("winArmor:player", 50,
            "Glückwunsch! Du gewinnst 5 Rüstung."),
    WIN_FULL_POINTS_PLAYER("winFullPoints:player", 25,
            "Glückwunsch! Deine Lebens-, Essens- und Rüstungspunkte werden komplett aufgefüllt"),
    WIN_PROGRESS_GAME("winProgress:game", 200,
            "Gewonnen. Ihr bekommt einen Fortschrittspunkt."),
    BLANK("blank", 200,
            "Verloren! Du bist leider auf einer Niete gelandet :/");
    // TODO: implement prices

    private final String price;
    private final int probability;
    private final String displayText;

    public String getPrice() {
        return price;
    }


}
