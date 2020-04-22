package com.cg.hcsAdmin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.cg.hcsAdmin.dto.Diagnosticcenter;

import com.cg.hcsAdmin.service.DiagnosticcenterService;

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
	   String message="center Inserted Successfully";
	   if(diagnosticcenterService.insertDiagnosticcenter(diagnosticcenter)==null)
		   message="Center Insertion Failed";
	   return new ResponseEntity<String>(message,HttpStatus.BAD_REQUEST);
   }
   
   
   
   @DeleteMapping("/deleteDiagnosticcenter/{centerId}")
   public String deleteDiagnosticcenter(@PathVariable int centerId)
   {
	   return diagnosticcenterService.deleteDiagnosticcenter(centerId); 
   }
}
