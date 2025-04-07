package org.example.model.dto;

import java.time.LocalDate;

/**
 * @author Anatoliy Shikin
 */
public record StandingDto(
        LocalDate date,
        TeamDto teamDto,
        Integer points
) {
}
