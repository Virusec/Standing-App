package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.model.dto.PlayerDto;
import org.example.service.PlayerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Anatoliy Shikin
 */
@RestController
@RequestMapping("/player")
@RequiredArgsConstructor
public class PlayerController {
    private final PlayerService playerService;

    @PostMapping("/create")
    ResponseEntity<String> create(PlayerDto playerDto) {
        return ResponseEntity.ok(playerService.create(playerDto));
    }

    @DeleteMapping("{lastName}/{firstName}")
    ResponseEntity<Void> delete(@PathVariable String lastName, @PathVariable String firstName) {
        playerService.delete(lastName, firstName);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/search")
    ResponseEntity<PlayerDto> getPlayerByLastName(@RequestParam String lastName) {
        return ResponseEntity.ok(playerService.getPlayerByLastName(lastName));
    }

    @GetMapping("/all")
    ResponseEntity<Page<PlayerDto>> getAllPlayers(@RequestParam int page, @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(playerService.getAllPlayers(pageable));
    }
}
