package com.example.check.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.check.entity.Doctor;
import com.example.check.entity.Patient;
import com.example.check.exception.ResourceNotFoundException;
import com.example.check.repository.DoctorRepository;
import com.example.check.repository.PatientRepository;
import com.example.check.service.DoctorService;
import com.example.check.service.PatientService;




@RestController
@RequestMapping("/api")
public class PatientController {

	@Autowired
	private PatientService patientService;
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private DoctorService doctorService;
	
	@GetMapping("/patients/list")
	public List<Patient> listAllPatients() {
		return patientService.listAllPatients();
	}
	
	@PostMapping("/patients/add")
	public ResponseEntity<Patient> savePatient(@RequestBody Patient patient) {
		return new ResponseEntity<Patient>(patientService.savePatient(patient), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/patients/{id}")
	public ResponseEntity<String> deletePatientById(@PathVariable(name="id", required = true) int patientId) {
		patientService.deletePatientById(patientId);
		return new ResponseEntity<String>("Patient deleted successfully.", HttpStatus.OK);
	}
	
	@GetMapping("/patients/suggest/{id}")
	public Object recommendDoctor(@PathVariable(name="id", required = true) int patientId) {
			return patientService.suggest(patientId);
	}
	
}
