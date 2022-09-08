package com.usermicroservices.entities;

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
public class Contact {
	
	@Id
	private long cId;
	
	private String  email;
	
	private String contactName;
	
	
	private long userId;

}
