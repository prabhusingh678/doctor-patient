package com.xcelore.service;

import com.xcelore.dto.DoctorDto;
import com.xcelore.entity.Doctor;
import com.xcelore.repository.DoctorRepository;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DoctorService {
    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public Doctor addDoctor(DoctorDto doctorDto) {
        Doctor doctor = new Doctor();
        // Map DTO to entity
        doctor.setName(doctorDto.getName());
        doctor.setCity(doctorDto.getCity());
        doctor.setEmail(doctorDto.getEmail());
        doctor.setPhone(doctorDto.getPhone());
        doctor.setSpeciality(doctorDto.getSpeciality());
        
        return doctorRepository.save(doctor);
    }

    public void removeDoctor(Long id) {
        doctorRepository.deleteById(id);
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }
}