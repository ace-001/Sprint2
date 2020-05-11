package com.cg.hcs.controller;

import java.util.List;
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
	public ResponseEntity<Boolean> insertAppointment(@RequestBody()Appointment appointment)
	{
		//String message="Appointment Successfully";
		Appointment dummy = appointmentService.getAppointmentByCenterIdAndAppointmentDate(appointment.getCenter().getCenterId(),appointment.getAppointmentDate());
		System.out.println(dummy!=null && dummy.getAppointmentDate().equals(appointment.getAppointmentDate()));
		if(dummy==null)
		{
			if(appointmentService.insertAppointment(appointment)==null)
				 return new ResponseEntity<Boolean>(false,HttpStatus.NOT_ACCEPTABLE);
			return new ResponseEntity<Boolean>(true,HttpStatus.OK);                    
		}
		else
			return new ResponseEntity<Boolean>(false,HttpStatus.NOT_ACCEPTABLE);
	}
	
	@GetMapping(value="/getAppointment/{appointmentId}",produces="application/json")
	public ResponseEntity<Optional<Appointment>> getAppointmentDetails(@PathVariable int appointmentId)
	{
		Optional<Appointment> appointment =  appointmentService.getAppointment(appointmentId);
		if(appointment.isPresent())
			return new ResponseEntity<Optional<Appointment>>(appointment,HttpStatus.OK);
		return new ResponseEntity<Optional<Appointment>>(appointment,HttpStatus.NOT_FOUND);
	}
	
	@GetMapping(value="/getAppointmentByDoc/{doctorId}",produces="application/json")
	public ResponseEntity<Optional<List<Appointment>>> getAppointmentByDoc(@PathVariable int doctorId)
	{
		Optional<List<Appointment>> appointment =  appointmentService.getAppointmentByDocId(doctorId);
		if(appointment.isPresent())
			return new ResponseEntity<Optional<List<Appointment>>>(appointment,HttpStatus.OK);
		return new ResponseEntity<Optional<List<Appointment>>>(appointment,HttpStatus.NOT_FOUND);
	}
	
	@GetMapping(value="/getAppointmentByPatient/{patientId}",produces="application/json")
	public ResponseEntity<Optional<List<Appointment>>> getAppointmentByPatient(@PathVariable int patientId)
	{
		Optional<List<Appointment>> appointment = appointmentService.getAppointmentByPatientId(patientId);
		if(appointment.isPresent())
			return new ResponseEntity<Optional<List<Appointment>>>(appointment,HttpStatus.OK);
		return new ResponseEntity<Optional<List<Appointment>>>(appointment,HttpStatus.NOT_FOUND);
	}
}
