package com.xcelore.controller;

import com.xcelore.dto.DoctorDto;
import com.xcelore.entity.Doctor;
import com.xcelore.service.DoctorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {
    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping
    public ResponseEntity<Doctor> addDoctor(@Valid @RequestBody DoctorDto doctorDto) {
        Doctor savedDoctor = doctorService.addDoctor(doctorDto);
        return new ResponseEntity<>(savedDoctor, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeDoctor(@PathVariable Long id) {
        doctorService.removeDoctor(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        return ResponseEntity.ok(doctorService.getAllDoctors());
    }
}
