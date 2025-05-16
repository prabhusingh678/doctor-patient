package com.xcelore.service;

import com.xcelore.enums.City;
import com.xcelore.enums.Speciality;
import com.xcelore.entity.Doctor;
import com.xcelore.entity.Patient;
import com.xcelore.repository.DoctorRepository;
import com.xcelore.repository.PatientRepository;
import com.xcelore.dto.SuggestionResponse;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SuggestionService {
    
    private final PatientRepository patientRepo;
    private final DoctorRepository doctorRepo;

    public SuggestionService(PatientRepository patientRepo, DoctorRepository doctorRepo) {
        this.patientRepo = patientRepo;
        this.doctorRepo = doctorRepo;
    }

    public SuggestionResponse suggestDoctors(Long patientId) {
        Patient patient = patientRepo.findById(patientId)
            .orElseThrow(() -> new RuntimeException("Patient not found"));
        
        // Edge Case 1: Check valid city
        try {
            City.valueOf(patient.getCity().toUpperCase());
        } catch (IllegalArgumentException e) {
            return new SuggestionResponse("We are still waiting to expand to your location");
        }

        Speciality requiredSpeciality = patient.getSymptom().getSpeciality();
        City patientCity = City.valueOf(patient.getCity().toUpperCase());
        
        List<Doctor> doctors = doctorRepo.findByCityAndSpeciality(patientCity, requiredSpeciality);
        
        // Edge Case 2: No doctors found
        if(doctors.isEmpty()) {
            return new SuggestionResponse("There isn't any doctor present at your location for your symptom");
        }
        
        return new SuggestionResponse(doctors);
    }
}