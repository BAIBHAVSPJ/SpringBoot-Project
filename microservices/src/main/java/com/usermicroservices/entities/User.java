package com.usermicroservices.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
	@Id
   private long userId;
   private String name;
   private String phone;
   
   
   List<Contact> contact=new ArrayList<>();
   
   
   
   
   
}
