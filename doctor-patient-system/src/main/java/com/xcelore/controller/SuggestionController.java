package com.xcelore.controller;

import com.xcelore.dto.SuggestionResponse;
import com.xcelore.service.SuggestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/suggestions")
public class SuggestionController {
    private final SuggestionService suggestionService;

    public SuggestionController(SuggestionService suggestionService) {
        this.suggestionService = suggestionService;
    }

    @GetMapping
    public ResponseEntity<SuggestionResponse> suggestDoctors(@RequestParam Long patientId) {
        return ResponseEntity.ok(suggestionService.suggestDoctors(patientId));
    }
}