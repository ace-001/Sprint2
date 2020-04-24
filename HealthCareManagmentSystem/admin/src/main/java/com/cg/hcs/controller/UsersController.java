package com.cg.hcs.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.hcs.dto.Users;
import com.cg.hcs.service.UserService;

@RestController
public class UsersController 
{
	@Autowired
	UserService userService;
	public void setUserService(UserService userService)
	{
		this.userService = userService;
	}
	
	@GetMapping("/login/{user_id}/{password}")
	public ResponseEntity<Optional<Users>> checkUser(@PathVariable String user_id,@PathVariable String password)
	{
		Optional<Users> user = userService.getUserById(user_id);
		if(user!=null && user.get().getPassword().equals(password))
			//return user;
			return new ResponseEntity<Optional<Users>>(user,HttpStatus.OK);
		return new ResponseEntity<Optional<Users>>(HttpStatus.NOT_FOUND);	
	}

	@PostMapping(value = "/register", consumes = "application/json")
	public ResponseEntity<String> registerUser(@RequestBody Users user)
	{
		try {
		String message="Registered Successfully";
		   if(userService.addUser(user)==null)
			   message="Registration Failed";
		   return new ResponseEntity<String>(message,HttpStatus.BAD_REQUEST);	
		}
		catch(Exception ex)
		{
			return new ResponseEntity<String>("Registration Failed",HttpStatus.BAD_REQUEST);
			
		}
	}
}

