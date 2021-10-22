package de.tensing.bossteam.gameelements.minigames.luckywheel;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum LuckyWheelPrice {
    TEST("TEST", "TEST_NAME", 20.3);
    // TODO: implement prices

    private final String price;
    private final String piceName;
    private final double probability;

    public String getPrice() {
        return price;
    }


}
