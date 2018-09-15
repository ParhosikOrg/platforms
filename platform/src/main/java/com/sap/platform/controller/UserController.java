package com.sap.platform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sap.platform.model.User;
import com.sap.platform.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	

	@CrossOrigin
	@PostMapping("/login")
	@ResponseBody
	public ResponseEntity<User> login( @RequestBody User user ) {
		
		User u = userService.verify(user);
		if( u != null )
			return new ResponseEntity<User>(HttpStatus.OK);
		else
			return new ResponseEntity<User>(HttpStatus.CONFLICT);

	}
	
	@CrossOrigin
	@GetMapping("/all")
	@ResponseBody
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
}
