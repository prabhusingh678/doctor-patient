package com.xcelore.dto;

import com.xcelore.enums.Symptom;
import javax.validation.constraints.*;

public class PatientDto {
    private Long id;

    @NotBlank(message = "Name is mandatory")
    @Size(min = 3, message = "Name must be at least 3 characters")
    private String name;

    @NotBlank(message = "City is mandatory")
    @Size(max = 20, message = "City must be at most 20 characters")
    private String city;

    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Phone is mandatory")
    @Size(min = 10, max = 15, message = "Phone must be 10-15 characters")
    private String phone;

    private Symptom symptom;

    // Getters and setters
}