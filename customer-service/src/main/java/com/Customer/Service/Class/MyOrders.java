package com.Customer.Service.Class;

import com.Customer.Service.entities.Customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyOrders {
	
	private Customer customer;
	
	
	private Product product;

}
