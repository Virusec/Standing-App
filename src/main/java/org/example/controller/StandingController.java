package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.model.dto.StandingDto;
import org.example.service.StandingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Anatoliy Shikin
 */
@RestController
@RequestMapping("/standings")
@RequiredArgsConstructor
public class StandingController {
    private final StandingService standingService;

    @GetMapping("/search")
    public ResponseEntity<List<StandingDto>> getStandingByDate(@RequestParam LocalDate localDate) {
        return ResponseEntity.ok(standingService.getStandingByDate(localDate));
    }
}
