package com.Product.Service.Services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Product.Service.Repository.ProductRepo;
import com.Product.Service.Services.ProductService;
import com.Product.Service.entity.Product;
@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepo productRepo;

	@Override
	public List<Product> getAllproduct() {
		
		List<Product> findAll = this.productRepo.findAll();
		
		return findAll;
	}

	@Override
	public Product getProductById(int pid) {
		 Optional<Product> findById = this.productRepo.findById(pid);
		Product product = findById.get();
		return product;
	}

	@Override
	public Product saveProduct(Product product) {
		
	  Product save = this.productRepo.save(product); 
		
		return save;
	}

}
