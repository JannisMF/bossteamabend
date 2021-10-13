package de.tensing.bossteam.services.models;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class Player {

    @Setter(AccessLevel.PRIVATE)
    private Integer id;

    private Integer health;

    private Integer food;

    private Integer armor;
}
