package de.tensing.bossteam.entities.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
/**
 * Probability is one out of thousand (.1%)
 */
public enum LuckyWheelPrice {
    WIN_PROGRESS_GAME("winProgress:game", 250,
            "Ihr bekommt einen Fortschrittspunkt"),
    WIN_ARMOR_ALL("winArmor:all", 50,
            "Alle Spieler erhalten einen Rüstungspunkt"),
    WIN_HEALTH_PLAYER("winHealth:player", 20,
            "Dein gesamtes Leben wird aufgefüllt"),
    WIN_FULL_POINTS_PLAYER("winFullPoints:player", 10,
            "Deine Lebens-, Essens- und Rüstungspunkte werden komplett aufgefüllt"),
    WIN_ARMOR_PLAYER("winArmor:player", 80,
            "Du gewinnst 5 Rüstung"),
    LOSE_HEALTH_PLAYER("loseHealth:player", 120,
            "Du verlierst 3 Leben"),
    LOSE_FOOD_PLAYER("loseFood:player", 75,
            "Du verlierst deine gesamten Essenspunkte"),
    LOSE_FOOD_ALL("loseFood:all", 40,
            "Alle Spieler verlieren 3 Essen"), // NOTICE: Food < 3 does NOT reduce Health!
    LOSE_PROGRESS_GAME("loseProgress:game", 65,
            "Ihr verliert einen Fortschrittspunkt"),
    LOSE_HEALTH_ALL("loseHealth:all", 55,
            "Alle Spieler verlieren 1 Leben"),
    LOSE_HEALTH_RANDOM("loseHealth:random", 165,
            "Ein zufälliger Spieler verliert 1 Leben"),
    BLANK("blank", 70,
            "Du bist leider auf einer Niete gelandet :/");

    private final String price;
    private final int probability;
    private final String displayText;

    public String getPrice() {
        return price;
    }
}
