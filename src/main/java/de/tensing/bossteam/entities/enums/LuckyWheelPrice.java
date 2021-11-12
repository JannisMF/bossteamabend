package de.tensing.bossteam.entities.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
/**
 * Probability is one out of thousand (.1%)
 */
public enum LuckyWheelPrice {
    WIN_PROGRESS_GAME("winProgress:game", 270,
            "Ihr bekommt einen Fortschrittspunkt"),
    WIN_ARMOR_ALL("winArmor:all", 30,
            "Alle Spieler erhalten einen Rüstungspunkt"),
    WIN_HEALTH_PLAYER("winHealth:player", 20,
            "Dein gesamtes Leben wird aufgefüllt"),
    WIN_FULL_POINTS_PLAYER("winFullPoints:player", 10,
            "Deine Lebens-, Essens- und Rüstungspunkte werden komplett aufgefüllt"),
    WIN_ARMOR_PLAYER("winArmor:player", 40,
            "Du gewinnst 3 Rüstung"),
    LOSE_HEALTH_PLAYER("loseHealth:player", 125,
            "Du verlierst 3 Leben"),
    LOSE_FOOD_PLAYER("loseFood:player", 50,
            "Du verlierst 4 Essen"),
    LOSE_FOOD_ALL("loseFood:all", 25,
            "Alle Spieler verlieren 2 Essen"), // NOTICE: Food < 3 does NOT reduce Health!
    LOSE_PROGRESS_GAME("loseProgress:game", 45,
            "Ihr verliert einen Fortschrittspunkt"),
    LOSE_HEALTH_ALL("loseHealth:all", 35,
            "Alle Spieler verlieren 1 Leben"),
    LOSE_HEALTH_RANDOM("loseHealth:random", 150,
            "Ein zufälliger Spieler verliert 1 Leben"),
    BLANK("blank", 200,
            "Niete :/");

    private final String price;
    private final int probability;
    private final String displayText;

    public String getPrice() {
        return price;
    }
}
