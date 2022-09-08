package com.Product.Service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Product.Service.entity.Product;
@Repository
public interface ProductRepo extends JpaRepository<Product ,Integer>{

}
