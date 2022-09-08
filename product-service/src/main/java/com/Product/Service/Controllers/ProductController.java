package com.Product.Service.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Product.Service.Services.ProductService;
import com.Product.Service.entity.Product;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@GetMapping("/")
	public List<Product> getAllproduct(){
		
		List<Product> allproduct = this.productService.getAllproduct();
		
		return allproduct;
		
		
		
	}
	@PostMapping("/")
	public Product saveProduct(@RequestBody Product product) {
		Product saveProduct = this.productService.saveProduct(product);
		
		return saveProduct;
		
	}
	@GetMapping("/{pid}")
	public Product getProductById(@RequestBody @PathVariable int pid) {
		
		
		Product productById = this.productService.getProductById(pid);
		
		
		
		return productById;
		
	}
	
	
	
	

}
