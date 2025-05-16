package com.xcelore.service;

import com.xcelore.dto.PatientDto;
import com.xcelore.entity.Patient;
import com.xcelore.repository.PatientRepository;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PatientService {
    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient addPatient(PatientDto patientDto) {
        Patient patient = new Patient();
        // Map DTO to entity
        patient.setName(patientDto.getName());
        patient.setCity(patientDto.getCity());
        patient.setEmail(patientDto.getEmail());
        patient.setPhone(patientDto.getPhone());
        patient.setSymptom(patientDto.getSymptom());
        
        return patientRepository.save(patient);
    }

    public void removePatient(Long id) {
        patientRepository.deleteById(id);
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }
}