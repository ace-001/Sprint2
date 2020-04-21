package com.anurag.cg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.anurag.cg.dto.Appointment;
import com.anurag.cg.service.AppointmentService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AppointmentController {

	@Autowired
	AppointmentService appointmentService;
	public void setAppointmentService(AppointmentService appointmentService)
	{
		this.appointmentService=appointmentService;
	}
	
	 @PostMapping(value="/addAppointment",consumes="application/json")
	   public ResponseEntity<String> insertAppointment(@RequestBody()Appointment appointment)
	   {
		  String message="Appointment Successfully";
		  Appointment dummy = appointmentService.getAppointmentByCenterIdAndTime(appointment.getCenterId(),appointment.getTime());
		  System.out.println(dummy!=null && dummy.getTime().equals(appointment.getTime()));
		  if(dummy==null)
		  {
			  if(appointmentService.insertAppointment(appointment)==null)
				  message="Appointment Failed";
		  }
		  else
		  if(!dummy.getTime().equals(appointment.getTime()))
		  {
			  if(appointmentService.insertAppointment(appointment)==null)
				  message="Appointment Failed";
		  } 	
		  return new ResponseEntity<String>(message,HttpStatus.OK);
	   }
}