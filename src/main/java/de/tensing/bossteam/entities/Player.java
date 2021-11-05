package de.tensing.bossteam.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Player {

    private Integer playerId;

    private Integer health;

    private Integer food;

    private Integer armor;

    private String name;
}
