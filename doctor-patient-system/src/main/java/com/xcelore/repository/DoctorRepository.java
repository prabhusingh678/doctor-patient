package com.xcelore.repository;

import com.xcelore.enums.City;
import com.xcelore.enums.Speciality;
import com.xcelore.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    List<Doctor> findByCityAndSpeciality(City city, Speciality speciality);
}