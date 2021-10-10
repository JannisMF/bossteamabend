package de.tensing.bossteam.player;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class PlayerDTO {

    @Setter(AccessLevel.NONE)
    @Id
    @Column(
            name = "playerId",
            updatable = false
    )
    private Integer playerId;
    @Column(
            name = "health",
            nullable = false
    )
    private Integer health;
    @Column(
            name = "food",
            nullable = false
    )
    private Integer food;
    @Column(
            name = "armor",
            nullable = false
    )
    private Integer armor;
}
