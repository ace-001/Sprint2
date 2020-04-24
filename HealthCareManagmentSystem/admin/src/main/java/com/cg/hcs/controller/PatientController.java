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

import com.cg.hcs.dto.Patient;
import com.cg.hcs.service.PatientService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PatientController 
{
	@Autowired
	PatientService patientService;
	public void setPatientService(PatientService patientService)
	{
		this.patientService=patientService;
	}
	
	@PostMapping(value="/addPatient",consumes="application/json")
	   public ResponseEntity<String> insertPatient(@RequestBody()Patient patient)
	   {
		   try
		   {
		   String message="Patient Inserted Successfully";
		  if(patientService.insertPatient(patient)==null)
			   message="Patient Insertion Failed";
		   return new ResponseEntity<String>(message,HttpStatus.BAD_REQUEST);
		   }
		   catch(Exception ex)
		   {
				return new ResponseEntity<String>(ex.getMessage()+" Insertion Failed",HttpStatus.BAD_REQUEST);
				 
		   }
		   
	   }
	   
	@DeleteMapping("/deletePatient/{patientId}")
	   public String deletePatient(@PathVariable int patientId)
	   {
		   return patientService.deletePatient(patientId);
	   }
	   @GetMapping("/getPatients")
	   public List<Patient> getPatients()
	   {
		   return patientService.getPatients();
	   }
	   
	   
	   @GetMapping(value="/getPatient/{patientId}",produces="application/json")
	   public ResponseEntity<Optional<Patient>> getPatientDetails(@PathVariable int patientId)
	   {
	 	  Optional<Patient> patient =  patientService.getPatient(patientId);
	 	  if(patient.isPresent())
	 		  return new ResponseEntity<Optional<Patient>>(patient,HttpStatus.OK);
	 	  return new ResponseEntity<Optional<Patient>>(patient,HttpStatus.NOT_FOUND);
	   }
	

}
