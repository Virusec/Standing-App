package org.example.service;

import org.example.model.dto.StandingDto;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Anatoliy Shikin
 */
public interface StandingService {
    List<StandingDto> getStandingByDate(LocalDate localDate);

}
