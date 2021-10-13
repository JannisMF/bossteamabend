package de.tensing.bossteam.controllers.mapper;

import de.tensing.bossteam.controllers.dtos.PlayerDTO;
import de.tensing.bossteam.services.models.Player;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PlayerDTOMapper {

    PlayerDTO convert(Player player);

    Player convert(PlayerDTO player);

    List<PlayerDTO> convertToDTO(List<Player> player);

    List<Player> convertToModel(List<PlayerDTO> player);

}
