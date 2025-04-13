package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.mapper.PlayerMapper;
import org.example.model.domain.Player;
import org.example.model.dto.PlayerDto;
import org.example.repository.PlayerRepository;
import org.example.service.PlayerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

/**
 * @author Anatoliy Shikin
 */
@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {
    private final PlayerRepository playerRepository;
    private final PlayerMapper playerMapper;

    @Override
    public String create(PlayerDto playerDto) {
        Player player = playerMapper.toEntity(playerDto);
        playerRepository.save(player);
        return "Сущность успешно создана";
    }

    @Override
    public void delete(String lastName, String firstName) {
        Player player = playerRepository.findByLastName(lastName);
        if (player.getFirstName().equals(firstName)) {
            playerRepository.deleteById(player.getId());
        }
    }

    @Override
    public PlayerDto getPlayerByLastName(String lastName) {
        Player player = playerRepository.findByLastName(lastName);

        return playerMapper.toDto(player);
    }

    @Override
    public Page<PlayerDto> getAllPlayers(Pageable pageable) {
        Page<Player> players = playerRepository.findAll(pageable);
        return players.map(playerMapper::toDto);
    }

    @Override
    public PlayerDto update(PlayerDto playerDto) {
        Player player = playerRepository
                .findByFirstNameAndLastName(playerDto.firstName(), playerDto.lastName())
                .orElseThrow(() -> new NoSuchElementException("Данного игрока не существует!"));
        player.setFirstName(playerDto.firstName());
        player.setLastName(playerDto.lastName());
        player.setTeamName(playerDto.teamName() != null ? playerDto.teamName() : null);
        return playerMapper.toDto(playerRepository.save(player));
    }
}
