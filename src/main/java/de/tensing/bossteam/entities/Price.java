package de.tensing.bossteam.entities;

import de.tensing.bossteam.entities.dtos.LuckyWheelPriceDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Price {
    private String time;
    private Player player;
    private LuckyWheelPriceDTO price;
}
