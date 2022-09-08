package com.usermicroservices.Services;

import com.usermicroservices.entities.User;

public interface UserService {
	
	public User createUser(User user);
	
	public User getUser(Long userId);

}
