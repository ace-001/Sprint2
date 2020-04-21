package com.anurag.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anurag.cg.dto.Appointment;
@Repository
public interface AppointmentDAO extends JpaRepository<Appointment,Integer> 
{
	public Appointment getAppointmentByCenterIdAndTime(String center_id,String time);
}
