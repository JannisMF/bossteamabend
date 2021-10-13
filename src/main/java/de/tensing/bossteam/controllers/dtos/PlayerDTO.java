package de.tensing.bossteam.controllers.dtos;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

// Validation
public class PlayerDTO {

    @NotNull
    private Integer id;

    private Integer health;

    private Integer food;

    private Integer armor;
}