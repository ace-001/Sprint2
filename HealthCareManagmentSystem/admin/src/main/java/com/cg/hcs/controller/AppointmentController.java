package com.cg.hcs.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.hcs.dto.Appointment;
import com.cg.hcs.service.AppointmentService;
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
		  Appointment dummy = appointmentService.getAppointmentByCenterIdAndAppointmentDate(appointment.getCenter(),appointment.getAppointmentDate());
		  System.out.println(dummy!=null && dummy.getAppointmentDate().equals(appointment.getAppointmentDate()));
		  if(dummy==null)
		  {
			  if(appointmentService.insertAppointment(appointment)==null)
				  message="Appointment Failed";
		  }
		  else
		  if(!dummy.getAppointmentDate().equals(appointment.getAppointmentDate()))
		  {
			  if(appointmentService.insertAppointment(appointment)==null)
				  message="Appointment Failed";
		  } 	
		  return new ResponseEntity<String>(message,HttpStatus.OK);
	   }
	@GetMapping(value="/getAppointment/{appointmentId}",produces="application/json")
	   public ResponseEntity<Optional<Appointment>> getAppointmentDetails(@PathVariable int appointmentId)
	   {
	 	  Optional<Appointment> appointment =  appointmentService.getAppointment(appointmentId);
	 	  if(appointment.isPresent())
	 		  return new ResponseEntity<Optional<Appointment>>(appointment,HttpStatus.OK);
	 	  return new ResponseEntity<Optional<Appointment>>(appointment,HttpStatus.NOT_FOUND);
	   }

}
