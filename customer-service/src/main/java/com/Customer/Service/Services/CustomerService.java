package com.Customer.Service.Services;

import com.Customer.Service.Class.MyOrders;
import com.Customer.Service.entities.Customer;

public interface CustomerService {
	
	public Customer saveCust(Customer customer);
	
	
	public MyOrders getMyorders( long custId);

}
