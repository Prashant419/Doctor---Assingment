package com.example.check.service;

import java.util.List;

import com.example.check.entity.Doctor;


public interface DoctorService {
	
	Doctor saveDoctor(Doctor doctor);
	
	List<Doctor> listAllDoctors();
	
	Doctor getDoctorById(int doctorId);
	 
    void deleteDoctorById(int doctorId);
}
