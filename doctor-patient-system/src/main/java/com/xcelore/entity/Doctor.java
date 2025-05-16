package com.xcelore.entity;

import com.xcelore.enums.City;
import com.xcelore.enums.Speciality;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 3)
    private String name;

    @Enumerated(EnumType.STRING)
    private City city;

    @Email
    private String email;

    @NotBlank
    @Size(min = 10, max = 15)
    private String phone;

    @Enumerated(EnumType.STRING)
    private Speciality speciality;

    // Getters and setters
}