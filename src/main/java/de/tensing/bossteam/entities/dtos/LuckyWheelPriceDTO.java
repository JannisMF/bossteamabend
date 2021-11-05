package de.tensing.bossteam.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LuckyWheelPriceDTO {
    private String price;
    private int probability;
    private String displayText;
}
