package com.example.check.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.check.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer>{

}
