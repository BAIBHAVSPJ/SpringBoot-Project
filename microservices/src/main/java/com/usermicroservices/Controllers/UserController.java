package com.usermicroservices.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usermicroservices.Services.UserService;
import com.usermicroservices.entities.User;

@RestController
@RequestMapping("/user")
public class UserController {
	
    @Autowired
	private UserService userService;
	
	
	@GetMapping("/{userId}")
	public User getUser(@PathVariable long userId) {
		
		
		
		return this.userService.getUser(userId);
		
		
	}
	
	@PostMapping("/")
	public User createUser(@RequestBody User user) {
		this.userService.createUser(user);
		
		return user;
		
	}

}
