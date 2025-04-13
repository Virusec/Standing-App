package org.example.model.dto;


import java.util.List;

/**
 * @author Anatoliy Shikin
 */
public record TeamDto(
        Long id,
        String name,
        List<PlayerDto> players
) {
}
