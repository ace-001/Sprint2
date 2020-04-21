package com.cg.healthCareSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.healthCareSystem.dto.Customer;
import com.cg.healthCareSystem.service.CustomerService;

@RestController
public class CustomerController 
{
	@Autowired
	CustomerService customerService;
	public void setCustomerService(CustomerService customerService)
	{
		this.customerService = customerService;
	}
	
	@GetMapping("/login/{user_id}/{password}")
	public Customer checkUser(@PathVariable String user_id,@PathVariable String password)
	{
		Customer customer = customerService.getCustomerById(user_id);
		if(customer!=null && customer.getPassword().equals(password))
			return customer;
		else
			return customer;
	}
	
	@PostMapping(value = "/register", consumes = "application/json")
	public ResponseEntity<String> registerCustomer(@RequestBody Customer customer)
	{
		String message="Registered Successfully";
		   if(customerService.addCustomer(customer)==null)
			   message="Registration Failed";
		   return new ResponseEntity<String>(message,HttpStatus.BAD_REQUEST);		
	}
}
