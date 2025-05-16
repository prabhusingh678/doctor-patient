package com.xcelore.entity;

import com.xcelore.enums.Symptom;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 3)
    private String name;

    @NotBlank
    @Size(max = 20)
    private String city;

    @Email
    private String email;

    @NotBlank
    @Size(min = 10, max = 15)
    private String phone;

    @Enumerated(EnumType.STRING)
    private Symptom symptom;

    // Getters and setters
}
