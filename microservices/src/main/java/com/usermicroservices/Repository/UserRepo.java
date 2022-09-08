package com.usermicroservices.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usermicroservices.entities.User;

public interface UserRepo extends JpaRepository<User,Long >{

	

}
