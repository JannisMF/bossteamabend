package de.tensing.bossteam.player;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Player {

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
