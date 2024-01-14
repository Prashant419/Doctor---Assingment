package com.example.check.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.check.entity.Doctor;
import com.example.check.entity.Patient;
import com.example.check.repository.DoctorRepository;
import com.example.check.repository.PatientRepository;
import com.example.check.service.PatientService;
import com.example.check.exception.ResourceNotFoundException;

@Service
public class PatientServiceImpl implements PatientService{
	
	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	Logger logger = (Logger) LoggerFactory.getLogger(PatientServiceImpl.class);
	
	@Override
	public Patient savePatient(Patient patient) {
		logger.info("Saving patient record!!!" );
		return patientRepository.save(patient);
	}

	@Override
	public List<Patient> listAllPatients() {
		logger.info("Retrieving list of patient records!!!" );
		return patientRepository.findAll();
	}

	@Override
	public Patient getPatientById(int patientId) {
		logger.info("Retrieving patient record with Patient Id : {}", patientId);
		return patientRepository.findById(patientId).orElseThrow(() -> new ResourceNotFoundException("Patient", "Id", patientId));
	}

	@Override
	public void deletePatientById(int patientId) {
		logger.info("Deleting patient record with Patient Id : {}", patientId);
		Patient p = patientRepository.findById(patientId)
				.orElseThrow(() -> new ResourceNotFoundException("Patient", "Id", patientId));	
		patientRepository.deleteById(patientId);
	}

	@Override
	public Object suggest(int patientId) {
		Patient p = patientRepository.findById(patientId)
				.orElseThrow(() -> new ResourceNotFoundException("Patient", "Id", patientId));	
		String pcity = p.getPcity();
	    String symptom = p.getSymptom();
	    String speciality="";
	    List<Doctor> dd = doctorRepository.CheckDoctorForCity(pcity);
		if(dd.size()==0) {
			return "We are still waiting to expand to your location";
		}
	    logger.info("Retrieving list of suggested doctor records!!!" );
		if(symptom.equalsIgnoreCase("Arthritis")) {
			speciality = "Orthopedic";
		}
		else if(symptom.equalsIgnoreCase("Backpain")) {
			speciality = "Orthopedic";
		
		}
		else if(symptom.equalsIgnoreCase("Tissue injuries")) {
			speciality = "Orthopedic";
		
		}
		else if(symptom.equalsIgnoreCase("Dysmenorrhea")) {
			speciality = "Gynecology";
	
		}
		else if(symptom.equalsIgnoreCase("Skin infection")) {
			speciality = "Dermatology";
	
		}
		else if(symptom.equalsIgnoreCase("Skin burn")) {
			speciality = "Dermatology";
		}
		else if(symptom.equalsIgnoreCase("Ear pain")) {
			speciality = "ENT";
		}
		List<Doctor> rr = doctorRepository.CheckDoctorForSpeciality(speciality);
		if(rr.size()==0) {
			return "There isn’t any doctor present at your location for your symptom";
		}
		return doctorRepository.DoctorSuggestions(pcity, speciality);
	}

}
