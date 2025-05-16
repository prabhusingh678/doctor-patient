package com.xcelore.doctor_patient_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@ComponentScan("com.xcelore") 
public class DoctorPatientSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoctorPatientSystemApplication.class, args);
	}

}
