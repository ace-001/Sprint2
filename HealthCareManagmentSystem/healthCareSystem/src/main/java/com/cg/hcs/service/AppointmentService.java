package com.cg.hcs.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.hcs.dao.AppointmentDAO;
import com.cg.hcs.dto.Appointment;
import com.cg.hcs.dto.Diagnosticcenter;

@Service
public class AppointmentService {
	@Autowired
    AppointmentDAO adao;
    public void setAdao(   AppointmentDAO adao) 
    { 
    	this.adao=adao;
    	} 
    @Transactional
    public Appointment insertAppointment(Appointment appointment)
    {
        return adao.save(appointment);
    }
    @Transactional(readOnly = true)
    public Appointment getAppointmentByCenterIdAndAppointmentDate(Diagnosticcenter centerId,LocalDate appointmentDate)
    {
    	return adao.getAppointmentByCenterIdAndAppointmentDate(centerId,appointmentDate);
    }
    @Transactional(readOnly=true)
    public Optional<Appointment> getAppointment(Integer appointmentId)
    {
    	return adao.findById(appointmentId);
    }
 }


