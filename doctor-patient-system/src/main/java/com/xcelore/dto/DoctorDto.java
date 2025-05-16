package com.xcelore.dto;

import com.xcelore.enums.City;
import com.xcelore.enums.Speciality;
import javax.validation.constraints.*;

public class DoctorDto {
    private Long id;

    @NotBlank(message = "Name is mandatory")
    @Size(min = 3, message = "Name must be at least 3 characters")
    private String name;

    private City city;

    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Phone is mandatory")
    @Size(min = 10, max = 15, message = "Phone must be 10-15 characters")
    private String phone;

    private Speciality speciality;

    // Getters and setters
}
