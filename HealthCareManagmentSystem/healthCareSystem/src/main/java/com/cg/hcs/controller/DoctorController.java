package com.cg.hcs.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.hcs.dto.Doctor;
import com.cg.hcs.service.DoctorService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class DoctorController 
{
	@Autowired
	DoctorService doctorService;
	public void setDoctorService(DoctorService doctorService)
	{
		this.doctorService=doctorService;
	}
	@PostMapping(value="/addDoctor",consumes="application/json")
	public ResponseEntity<String> insertDoctor(@RequestBody()Doctor doctor)
	{
		try
		{
			String message="Doctor Inserted Successfully";
			if(doctorService.insertDoctor(doctor)==null)
				message="Doctor Insertion Failed";
			return new ResponseEntity<String>(message,HttpStatus.CREATED);
		}
		catch(Exception ex)
		{
			return new ResponseEntity<String>(ex.getMessage()+" Insertion Failed",HttpStatus.BAD_REQUEST);
		}
	}
	@DeleteMapping("/deleteDoctor/{doctorId}")
	public String deleteDoctor(@PathVariable int doctorId)
	{
		return doctorService.deleteDoctor(doctorId);
	}
	@GetMapping(value="/getDoctors",produces="application/json")
	public List<Doctor> getDoctors()
	{
		return doctorService.getDoctors();
	}
	@GetMapping(value="/getDoctor/{doctorId}",produces="application/json")
	public ResponseEntity<Optional<Doctor>> getDoctorDetails(@PathVariable int doctorId)
	{
		Optional<Doctor> doctor =  doctorService.getDoctor(doctorId);
		if(doctor.isPresent())
			return new ResponseEntity<Optional<Doctor>>(doctor,HttpStatus.OK);
		return new ResponseEntity<Optional<Doctor>>(doctor,HttpStatus.NOT_FOUND);
	}
	@GetMapping(value="/getDoctorByCenterAndTest/{centerId}/{testId}",produces="application/json")
	public ResponseEntity<Optional<Integer>> getDoctorId(@PathVariable int centerId,@PathVariable int testId)
	{
		Optional<Integer> doctorId =  doctorService.getDoctorByCenterIdAndTestId(centerId, testId);
		if(doctorId.isPresent())
			return new ResponseEntity<Optional<Integer>>(doctorId,HttpStatus.OK);
		return new ResponseEntity<Optional<Integer>>(doctorId,HttpStatus.NOT_FOUND);
	}
	@GetMapping(value="/getDoctorByUserId/{userId}",produces="application/json")
	public ResponseEntity<Optional<Doctor>> getDoctorIdByUserId(@PathVariable String userId)
	{
		Optional<Doctor> doctorId = doctorService.getDoctorUserId(userId);
		if(doctorId.isPresent())
			return new ResponseEntity<Optional<Doctor>>(doctorId,HttpStatus.OK);
		return new ResponseEntity<Optional<Doctor>>(doctorId,HttpStatus.NOT_FOUND);
	}
}