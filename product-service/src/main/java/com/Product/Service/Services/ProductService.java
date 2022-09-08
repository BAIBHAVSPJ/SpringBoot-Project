package com.Product.Service.Services;

import java.util.List;

import com.Product.Service.entity.Product;

public interface ProductService {
	
	
	public List<Product> getAllproduct();
	
	public Product getProductById(int pid);
	
	public Product saveProduct(Product product);

}
