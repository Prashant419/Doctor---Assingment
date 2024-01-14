package com.example.check.controller;

import java.util.List;

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
import com.example.check.service.DoctorService;

@RestController
@RequestMapping("/api")
public class DoctorController {
	
	@Autowired
	private DoctorService doctorService;
	
	@GetMapping("/doctors/list")
	public List<Doctor> listAllDoctors() {
		return doctorService.listAllDoctors();
	}
	
	@PostMapping("/doctors/add")
	public ResponseEntity<Doctor> saveDoctor(@RequestBody Doctor doctor) {
		return new ResponseEntity<Doctor>(doctorService.saveDoctor(doctor), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/doctors/{id}")
	public ResponseEntity<String> deleteDoctorById(@PathVariable("id") int doctorId) {
		doctorService.deleteDoctorById(doctorId);
		return new ResponseEntity<String>("Doctor deleted successfully.", HttpStatus.OK);
	}
	
}
