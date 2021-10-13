package de.tensing.bossteam.repositories.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "tbl_player")
public class PlayerEntity {

    @Id
    @Column(name = "id", updatable = false)
    private Integer id;

    @Column(name = "health", nullable = false)
    private Integer health;

    @Column(name = "food", nullable = false)
    private Integer food;

    @Column(name = "armor", nullable = false)
    private Integer armor;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(
            name = "tbl_player_roles",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<RoleEntity> roles = new HashSet<>();
}
