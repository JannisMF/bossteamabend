package de.tensing.bossteam.entities.enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LuckyWheelPriceTest {

    @Test
    public void luckkyWheelPrice_probabilityIsNotOneOfAThousand_ReturnsNotHappyDay() {
        LuckyWheelPrice[] allPrices = LuckyWheelPrice.values();
        int priceProb = 0; // Current Price Probability
        for (LuckyWheelPrice price : allPrices) {
            priceProb += price.getProbability();
        }
        assertEquals(1000, priceProb);
    }
}
