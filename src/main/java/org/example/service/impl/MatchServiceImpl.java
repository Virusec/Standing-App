package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.mapper.MatchMapper;
import org.example.model.domain.Match;
import org.example.model.dto.MatchDto;
import org.example.repository.MatchRepository;
import org.example.service.MatchService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Anatoliy Shikin
 */
@Service
@RequiredArgsConstructor
public class MatchServiceImpl implements MatchService {
    private final MatchRepository matchRepository;
    private final MatchMapper matchMapper;

    @Override
    @Transactional
    public String create(MatchDto matchDto) {
        matchRepository.save(matchMapper.toEntity(matchDto));
        return "Матч успешно создан!";
    }

    @Override
    public Integer countPoints(String teamName, LocalDate localDate) {
        List<Match> byOwnerTeamName = matchRepository.findByOwnerTeamName(teamName, localDate);
        List<Match> listOwnerTeam = byOwnerTeamName.stream()
                .filter(match -> match.getOwnerTeam().getName().equals(teamName))
                .filter(Match::isOwnerWin)
                .toList();

        List<Match> listGuestTeam = byOwnerTeamName.stream()
                .filter(match -> match.getGuestTeam().getName().equals(teamName))
                .filter(match -> !match.isOwnerWin())
                .toList();

        return (listGuestTeam.size() + listGuestTeam.size()) * 3;
    }

}
