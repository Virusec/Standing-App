package org.example.model.dto;


import java.util.List;

/**
 * @author Anatoliy Shikin
 */
public record TeamDto(
        String name,
        List<PlayerDto> players
) {
}
