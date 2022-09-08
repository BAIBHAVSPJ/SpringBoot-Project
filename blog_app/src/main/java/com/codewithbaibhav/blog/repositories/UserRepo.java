package com.codewithbaibhav.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithbaibhav.blog.entities.Users;

public interface UserRepo extends JpaRepository<Users,Integer> {

}
