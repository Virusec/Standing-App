package org.example.mapper;

import org.example.model.domain.Team;
import org.example.model.dto.TeamDto;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author Anatoliy Shikin
 */
@Mapper(componentModel = "spring")
public interface TeamMapper {

    TeamDto toDto(Team team);

    Team toEntity(TeamDto teamDto);

    List<TeamDto> toListDto(List<Team> teamList);
}
