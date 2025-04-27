package org.example.model.dto;

import java.time.LocalDate;

/**
 * @author Anatoliy Shikin
 */
public record MatchDto(
        String season,
        LocalDate date,
        TeamDto ownerTeam,
        TeamDto guestTeam,
        int ownerPoints,
        int guestPoints,
        boolean isOwnerWin
) {
}
