package com.example.check.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.check.entity.Doctor;
import com.example.check.exception.ResourceNotFoundException;
import com.example.check.repository.DoctorRepository;
import com.example.check.repository.PatientRepository;
import com.example.check.service.DoctorService;


@Service
public class DoctorServiceImpl implements DoctorService{

	@Autowired
	private DoctorRepository doctorRepository;	
	
	@Autowired
	private PatientRepository patientRepository;
	
	Logger logger = (Logger) LoggerFactory.getLogger(DoctorServiceImpl.class);
	
	@Override
	public Doctor saveDoctor(Doctor doctor) {
		logger.info("Saving doctor record!!!" );
		return doctorRepository.save(doctor);
	}

	@Override
	public List<Doctor> listAllDoctors() {
		logger.info("Retrieving list of doctor records!!!" );
		return doctorRepository.findAll();
	}

	@Override
	public Doctor getDoctorById(int doctorId) {
		logger.info("Retrieving doctor record with Doctor Id : {}", doctorId);
		//check whether doctor with given id exists or not else throw exception
		return doctorRepository.findById(doctorId).orElseThrow(() -> new ResourceNotFoundException("Doctor", "Id", doctorId));
	}

	@Override
	public void deleteDoctorById(int doctorId) {
		// TODO Auto-generated method stub
		Doctor doctor = doctorRepository.findById(doctorId)
				.orElseThrow(() -> new ResourceNotFoundException("Doctor", "Id", doctorId));
		logger.info("Doctor record with Doctor Id : {} is deleted successfully", doctorId);
		doctorRepository.deleteById(doctorId);
		
	}

}
