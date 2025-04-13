package org.example.service;

import org.example.model.dto.TeamDto;

import java.util.List;

/**
 * @author Anatoliy Shikin
 */
public interface TeamService {
    String createTeam(TeamDto teamDto);

    TeamDto update(TeamDto teamDto);

    TeamDto getTeamByName(String name);

    List<TeamDto> getAllTeams();

    void delete(Long id);
}
