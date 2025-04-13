package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.model.dto.TeamDto;
import org.example.service.TeamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Anatoliy Shikin
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/team")
public class TeamController {
    private final TeamService teamService;

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody TeamDto teamDto) {
        return ResponseEntity.ok(teamService.createTeam(teamDto));
    }

    @PutMapping("/update")
    public ResponseEntity<TeamDto> update(@RequestBody TeamDto teamDto) {
        return ResponseEntity.ok(teamService.update(teamDto));
    }

    @GetMapping("/search")
    public ResponseEntity<TeamDto> getTeamByName(@RequestParam String name) {
        return ResponseEntity.ok(teamService.getTeamByName(name));
    }

    @GetMapping("/all")
    public ResponseEntity<List<TeamDto>> getAllTeams() {
        return ResponseEntity.ok(teamService.getAllTeams());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        teamService.delete(id);
        return ResponseEntity.ok().build();
    }
}
