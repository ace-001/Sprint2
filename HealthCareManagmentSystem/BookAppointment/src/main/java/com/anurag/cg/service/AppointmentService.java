package com.anurag.cg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anurag.cg.dao.AppointmentDAO;
import com.anurag.cg.dto.Appointment;

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
    public Appointment getAppointmentByCenterIdAndTime(String center_id, String time)
    {
    	return adao.getAppointmentByCenterIdAndTime(center_id,time);
    }
 }


