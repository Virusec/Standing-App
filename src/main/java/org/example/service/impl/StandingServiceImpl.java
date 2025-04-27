package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.model.dto.StandingDto;
import org.example.model.dto.TeamDto;
import org.example.repository.StandingRepository;
import org.example.service.MatchService;
import org.example.service.StandingService;
import org.example.service.TeamService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Anatoliy Shikin
 */
/*

 */
@Service
@RequiredArgsConstructor
public class StandingServiceImpl implements StandingService {
    private final StandingRepository standingRepository;
    private final MatchService matchService;
    private final TeamService teamService;

    @Override
    public List<StandingDto> getStandingByDate(LocalDate localDate) {
        List<StandingDto> standingDtoList = new ArrayList<>();
        List<TeamDto> allTeams = teamService.getAllTeams();
        for (int i = 0; i < allTeams.size(); i++) {
            TeamDto teamDto = allTeams.get(i);
            int a = matchService.countPoints(teamDto.name(), localDate);
            standingDtoList.add(i, new StandingDto(localDate, teamDto, a));
        }
        standingDtoList.sort((t1, t2) -> Integer.compare(t2.points(), t1.points()));

        return standingDtoList;
    }

}
