package com.example.check.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.check.entity.Doctor;
import com.example.check.entity.Patient;

public interface PatientService {
	
	    Patient savePatient(Patient patient);
		
		List<Patient> listAllPatients();
		
		Patient getPatientById(int doctorId);
		 
	    void deletePatientById(int doctorId);
	    
	    Object suggest(int patientId);
	    
}
