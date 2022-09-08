package com.Customer.Service.Services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.Customer.Service.Class.MyOrders;
import com.Customer.Service.Class.Product;
import com.Customer.Service.Repository.CustomerRepo;
import com.Customer.Service.entities.Customer;
@Service
public class CustomerService implements com.Customer.Service.Services.CustomerService {
	@Autowired
    private CustomerRepo customerRepo;
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public Customer saveCust(Customer customer) {
		Customer save = this.customerRepo.save(customer);
		return save;
	}

	@Override
	public MyOrders getMyorders(long custId) {
		Optional<Customer> findById = customerRepo.findById(custId);
		int pid=findById.get().getPid();
		Product product = restTemplate.getForObject("http://localhost:6060/product/"+ pid , Product.class);
		MyOrders myorder=new MyOrders();
		myorder.setCustomer(findById.get());
		myorder.setProduct(product);
		return myorder;
	}
}
