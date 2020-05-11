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

import com.cg.hcs.dto.Test;
import com.cg.hcs.service.TestService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TestController 
{
	@Autowired
	TestService testService;
	public void setTestService(TestService testService)
	{
		this.testService = testService;
	}
	
	@DeleteMapping("/deleteTest/{testId}")
	public String deleteTest(@PathVariable int testId)
	{
	   return testService.deleteTest(testId); 
	}
	
	@PostMapping(value="/addTest",consumes="application/json")
	public ResponseEntity<String> insertTest(@RequestBody()Test test)
	{
		try
		{
			String message="Test Inserted Successfully";
			if(testService.insertTest(test)==null)
				message="Test Insertion Failed";
			return new ResponseEntity<String>(message,HttpStatus.BAD_REQUEST);
		}
		catch(Exception ex)
		{
			return new ResponseEntity<String>(ex.getMessage()+" Insertion Failed",HttpStatus.BAD_REQUEST);	
		}
	}
	@GetMapping("/getTests")	
	public List<Test> getTests()
	{
		return testService.getTests();
	}
	@GetMapping(value="/getTest/{testId}",produces="application/json")
	public ResponseEntity<Optional<Test>> getTestDetails(@PathVariable int testId)
	{
		Optional<Test> test =  testService.getTest(testId);
		if(test.isPresent())
			return new ResponseEntity<Optional<Test>>(test,HttpStatus.OK);
		return new ResponseEntity<Optional<Test>>(test,HttpStatus.NOT_FOUND);
	}

	@GetMapping(value="/getTestsById/{testIds}",produces="application/json")
	public ResponseEntity<List<Test>> getMultipleTestById(@PathVariable int testIds[])
	{
		List<Test> test =  testService.getTestById(testIds);
		if(!test.isEmpty())
			return new ResponseEntity<List<Test>>(test,HttpStatus.OK);
		return new ResponseEntity<List<Test>>(test,HttpStatus.NOT_FOUND);
	}

}
