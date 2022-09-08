package com.codewithbaibhav.blog.services;

import java.util.List;

import com.codewithbaibhav.blog.payloads.UserDto;

public interface UserService {
	
	
	UserDto createUser(UserDto User);
	
	UserDto updateUser(UserDto user,Integer userId);
	
	UserDto getUserById(Integer userId);
	
	List<UserDto> getAllUsers();
	
	
	void deleteUser(Integer userId);
	
	

}
