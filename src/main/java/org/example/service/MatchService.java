package org.example.service;

import org.example.model.dto.MatchDto;
import org.example.model.dto.TeamDto;

import java.time.LocalDate;

/**
 * @author Anatoliy Shikin
 */
public interface MatchService {
    String create(MatchDto matchDto);

    Integer countPoints(String teamName, LocalDate localDate);

}
