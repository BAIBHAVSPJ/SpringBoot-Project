package com.codewithbaibhav.blog.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithbaibhav.blog.entities.Users;
import com.codewithbaibhav.blog.payloads.UserDto;
import com.codewithbaibhav.blog.services.UserService;
import com.codewithbaibhav.blog.repositories.UserRepo;
import com.codewithbaibhav.blog.repositories.*;  

    public UserRepo u

    @Service
    public class UserServiceImpl implements UserService {

	@Override
	public UserDto createUser(UserDto userDto) {
		 Users user=this.dtoToUser(userDto);
		 Users saveuser =this.userRepo.save(user);
		 
		
		return this.UserToDto(saveuser);
	}

	@Override
	public UserDto updateUser(UserDto user, Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto getUserById(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDto> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(Integer userId) {
		// TODO Auto-generated method stub

	}
	private Users  dtoToUser(UserDto userDto) {
		
	      Users user=new Users();
	      
		user.setId(userDto.getId());
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setAbout(userDto.getAbout());
		user.setPassword(userDto.getPassword());
		return user;
		
		
	}
	 private UserDto UserToDto(Users user) {
		UserDto userDto=new UserDto();
		userDto.setId(userDto.getId());
		userDto.setName(userDto.getName());
		userDto.setEmail(userDto.getEmail());
		userDto.setAbout(userDto.getAbout());
		userDto.setPassword(userDto.getPassword());
		
		
		return userDto;
		
	 
	 }
	

}
