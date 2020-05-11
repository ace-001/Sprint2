package com.cg.hcs.controller;

import java.util.NoSuchElementException;
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

import com.cg.hcs.dto.Users;
import com.cg.hcs.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
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
		System.out.println(" "+user_id+" "+password);
		Optional<Users> user = userService.getUserById(user_id);
		try
		{
			if(user!=null && user.get().getPassword().equals(password))
				return new ResponseEntity<Optional<Users>>(user,HttpStatus.OK);
		}
		catch(NoSuchElementException e)
		{
			return new ResponseEntity<Optional<Users>>(user,HttpStatus.NOT_FOUND);
		}
		return null;
	}

	@PostMapping(value = "/register", consumes = "application/json")
	public ResponseEntity<String> registerUser(@RequestBody Users user)
	{
		try 
		{
			String message="Registered Successfully";
			if(userService.getUserById(user.getUserId()).isPresent())
			{
				message="Registration Failed";
				return new ResponseEntity<String>("Registration Failed",HttpStatus.BAD_REQUEST);
			}
			else
				if(userService.addUser(user)==null || user.getPassword().isEmpty())
				{
					message="Registration Failed";
					return new ResponseEntity<String>("Registration Failed",HttpStatus.BAD_REQUEST);
				}
			else
				return new ResponseEntity<String>(message,HttpStatus.CREATED);	
		}
		catch(Exception ex)
		{
			return new ResponseEntity<String>("Registration Failed",HttpStatus.BAD_REQUEST);
		}
	}
}

