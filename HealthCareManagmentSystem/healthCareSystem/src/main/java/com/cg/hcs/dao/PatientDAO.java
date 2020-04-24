package com.cg.hcs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.hcs.dto.Doctor;
import com.cg.hcs.dto.Patient;
import com.cg.hcs.dto.Users;

public interface PatientDAO extends JpaRepository<Patient, Integer>
{
	@Query("select p from Patient p where p.user=:user")
	public Doctor getPatientByUser(Users user); 
}
