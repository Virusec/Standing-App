package org.example.mapper;

import org.example.model.domain.Player;
import org.example.model.dto.PlayerDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author Anatoliy Shikin
 */
@Mapper(componentModel = "spring")
public interface PlayerMapper {

    PlayerDto toDto(Player player);
    @Mapping(target = "id", ignore = true)
    Player toEntity(PlayerDto playerDto);
}
