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

import com.cg.hcs.dto.Diagnosticcenter;
import com.cg.hcs.service.DiagnosticcenterService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class DiagnosticcenterController 
{
	@Autowired
	DiagnosticcenterService diagnosticcenterService;
	public void setDiagnosticcenterService(DiagnosticcenterService diagnosticcenterService)
	{
		this.diagnosticcenterService=diagnosticcenterService;
	}
	

   @PostMapping(value="/addDiagnosticcenter",consumes="application/json")
   public ResponseEntity<String> insertDiagnosticcenter(@RequestBody()Diagnosticcenter diagnosticcenter)
   {
	   try
	   {
	   String message="center Inserted Successfully";
	  if(diagnosticcenterService.insertDiagnosticcenter(diagnosticcenter)==null)
		   message="Center Insertion Failed";
	   return new ResponseEntity<String>(message,HttpStatus.BAD_REQUEST);
	   }
	   catch(Exception ex)
	   {
			return new ResponseEntity<String>(ex.getMessage()+" Insertion Failed",HttpStatus.BAD_REQUEST);
			 
	   }
	   
   }
   
   @DeleteMapping("/deleteDiagnosticcenter/{centerId}")
   public String deleteDiagnosticcenter(@PathVariable int centerId)
   {
	   return diagnosticcenterService.deleteDiagnosticcenter(centerId); 
   }
   @GetMapping("/getDiagnosticcenters")
   public List<Diagnosticcenter> getDiagnosticcenters()
   {
	   return diagnosticcenterService.getDiagnosticcenters();
   }
   
   
   @GetMapping(value="/getDiagnosticcenter/{centerId}",produces="application/json")
   public ResponseEntity<Optional<Diagnosticcenter>> getDiagnosticcenterDetails(@PathVariable int centerId)
   {
 	  Optional<Diagnosticcenter> diagnosticcenter =  diagnosticcenterService.getDiagnosticcenter(centerId);
 	  if(diagnosticcenter.isPresent())
 		  return new ResponseEntity<Optional<Diagnosticcenter>>(diagnosticcenter,HttpStatus.OK);
 	  return new ResponseEntity<Optional<Diagnosticcenter>>(diagnosticcenter,HttpStatus.NOT_FOUND);
   }
   
}
