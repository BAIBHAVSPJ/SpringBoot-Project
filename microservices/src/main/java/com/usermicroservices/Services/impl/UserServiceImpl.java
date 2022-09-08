package com.usermicroservices.Services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usermicroservices.Repository.UserRepo;
import com.usermicroservices.Services.UserService;
import com.usermicroservices.entities.User;
@Service
public class UserServiceImpl implements UserService {
	 @Autowired
     private UserRepo userRepo;
	 
	 
	 
	@Override
	public User getUser(Long userId) {
		Optional<User> findById = this.userRepo.findById(userId);
		User user = findById.get();
		return user;
	}



	@Override
	public User createUser(User user) {
		User save = this.userRepo.save(user);
		return save;
	}

}
