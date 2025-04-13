package org.example.service;

import org.example.model.dto.PlayerDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author Anatoliy Shikin
 */
public interface PlayerService {
    String create(PlayerDto playerDto);

    void delete(String lastName, String firstName);

    PlayerDto getPlayerByLastName(String lastName);

    Page<PlayerDto> getAllPlayers(Pageable pageable);

    PlayerDto update(PlayerDto playerDto);
}
