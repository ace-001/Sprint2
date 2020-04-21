package com.anurag.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anurag.cg.dto.Diagnosticcenter;
import com.anurag.cg.service.DiagnosticcenterService;
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
	@GetMapping("/getDiagnosticcenters")
	   public List<Diagnosticcenter> getDiagnosticcenters()
	   {
		   return diagnosticcenterService.getDiagnosticcenters();
	   }

}
