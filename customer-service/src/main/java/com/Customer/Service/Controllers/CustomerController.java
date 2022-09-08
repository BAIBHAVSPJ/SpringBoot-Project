package com.Customer.Service.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Customer.Service.Class.MyOrders;
import com.Customer.Service.Services.CustomerService;
import com.Customer.Service.entities.Customer;

@RestController
@RequestMapping("/Customer")
public class CustomerController {
	
	@Autowired 
	private CustomerService customerService;

	@PostMapping("/")
	public Customer saveCust(@RequestBody Customer customer) {
		
		    Customer saveCust = this.customerService.saveCust(customer);
		
		return saveCust;
		
	}
	
	@GetMapping("/myorder/{custId}")
	public MyOrders getMyorders(@PathVariable long custId) {
		
		MyOrders myorders = this.customerService.getMyorders(custId);
		
		return myorders;
		
	}
}
