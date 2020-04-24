package com.cg.hcs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.hcs.dto.Doctor;
import com.cg.hcs.dto.Users;

public interface DoctorDAO extends JpaRepository<Doctor, Integer>
{
	@Query("select d from Doctor d where d.user=:user")
	public Doctor getDoctorByUser(Users user); 
}