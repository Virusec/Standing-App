package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.mapper.PlayerMapper;
import org.example.mapper.TeamMapper;
import org.example.model.domain.Player;
import org.example.model.domain.Team;
import org.example.model.dto.PlayerDto;
import org.example.model.dto.TeamDto;
import org.example.repository.TeamRepository;
import org.example.service.TeamService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author Anatoliy Shikin
 */
@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {
    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper;
    private final PlayerMapper playerMapper;

    @Override
    public String createTeam(TeamDto teamDto) {
        teamRepository.save(teamMapper.toEntity(teamDto));
        return "Команда успешно создана.";
    }

    @Override
    public TeamDto update(TeamDto teamDto) {
        Team team = teamRepository.findById(teamDto.id())
                .orElseThrow(() -> new NoSuchElementException("Данного команды не существует!"));
        team.setName(teamDto.name() == null ? team.getName() : teamDto.name());
        team.setPlayers(updatePlayers(teamDto, team));
        return teamMapper.toDto(team);
    }

    private List<Player> updatePlayers(TeamDto teamDto, Team team) {
        List<Player> players = team.getPlayers();

        List<PlayerDto> dtoList = teamDto.players();
        if (players == null && dtoList == null) {
            return null;
        }
        if (players != null && dtoList == null) {
            return players;
        }
        if (players != null && dtoList != null) {
            players.addAll(playerMapper.toListEntity(dtoList));
            return players;
        }
        return null;
    }

    @Override
    public TeamDto getTeamByName(String name) {
        return teamMapper.toDto(teamRepository
                .findByName(name)
                .orElseThrow(() -> new NoSuchElementException("Данной команды не существует!")));
    }

    @Override
    public List<TeamDto> getAllTeams() {
        return teamMapper.toListDto(teamRepository.findAll());
    }

    @Override
    public void delete(Long id) {
        teamRepository.delete(teamRepository
                .findById(id)
                .orElseThrow(() -> new NoSuchElementException("Данный id не существует!")));
    }
}
