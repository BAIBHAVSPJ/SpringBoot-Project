package com.Customer.Service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Customer.Service.entities.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Long> {

}
