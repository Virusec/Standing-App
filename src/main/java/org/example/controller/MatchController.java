package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.model.dto.MatchDto;
import org.example.service.MatchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Anatoliy Shikin
 */
@RestController
@RequestMapping("/match")
@RequiredArgsConstructor
public class MatchController {
    private final MatchService matchService;

    @PostMapping("/create")
    ResponseEntity<String> create(@RequestBody MatchDto matchDto) {
        return ResponseEntity.ok(matchService.create(matchDto));
    }

}
