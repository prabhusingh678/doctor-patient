package com.xcelore.dto;

import com.xcelore.entity.Doctor;
import java.util.List;

public class SuggestionResponse {
    private String message;
    private List<Doctor> doctors;

    public SuggestionResponse(String message) {
        this.message = message;
    }

    public SuggestionResponse(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    // Getters
}
