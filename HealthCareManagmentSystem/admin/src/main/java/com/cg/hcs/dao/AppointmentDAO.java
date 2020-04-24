package com.cg.hcs.dao;

import java.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.hcs.dto.Appointment;
import com.cg.hcs.dto.Diagnosticcenter;

import org.springframework.data.jpa.repository.Query;
@Repository
public interface AppointmentDAO extends JpaRepository<Appointment,Integer> 
{
	@Query("select a from Appointment a where a.center=:center and a.appointmentDate=:appointmentDate")
	public Appointment  getAppointmentByCenterIdAndAppointmentDate(Diagnosticcenter center,LocalDate appointmentDate);
	
}

