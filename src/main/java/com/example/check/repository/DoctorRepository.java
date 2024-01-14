package com.example.check.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.check.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Integer>{
	
	@Query("from abc u where dcity=:n and speciality=:m")
	public List<Doctor> DoctorSuggestions(@Param("n") String city, @Param("m") String symptom);
	
	@Query("from abc u where dcity=:n")
	public List<Doctor> CheckDoctorForCity(@Param("n") String city);
	
	@Query("from abc u where speciality=:m")
	public List<Doctor> CheckDoctorForSpeciality(@Param("m") String symptom);
}
