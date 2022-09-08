package com.codewithdurgesh.blog.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewithdurgesh.blog.paylods.ApiResponse;
import com.codewithdurgesh.blog.paylods.CategoryDto;
import com.codewithdurgesh.blog.services.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	// Create
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(@RequestBody @Valid CategoryDto categoryDto){
		CategoryDto createCategory=this.categoryService.createCategory(categoryDto);
		
		
		
		return new ResponseEntity<CategoryDto>(createCategory,HttpStatus.CREATED);
		
	}
	
	
	
	
	
	
	// Update
	@PutMapping("/{categoryId")
	public ResponseEntity<CategoryDto> updateCategory( @Valid @RequestBody CategoryDto categoryDto,@PathVariable Integer categoryId){
		CategoryDto updateCategory =this.categoryService.updateCategory(categoryDto, categoryId);
		return new ResponseEntity<CategoryDto>(updateCategory,HttpStatus.CREATED);
		
	
	
	
	
	
	
	
	}
	
	
	
	// Delete
	@DeleteMapping("/{categoryId}")
	public ResponseEntity<ApiResponse>deleteCategory(@PathVariable Integer categoryId){
		this.categoryService.deleteCategory(categoryId);
		
		return new ResponseEntity<ApiResponse>(new ApiResponse("category is deleted Sucessfully !!",false),HttpStatus.OK);
		
	}
	
	
	
	
	
	
	
	
	
	// Get 
	@GetMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> getCategory(@PathVariable Integer categoryId){
		
		
		
		CategoryDto categoryDto=this.categoryService.getCategory(categoryId);
		return new ResponseEntity<CategoryDto>(categoryDto,HttpStatus.OK);
		
		
		
		
	}
	
	
	
	
	//Get All
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getCategories(){
		
		List<CategoryDto> categories=this.categoryService.getAllCategory();		
		return ResponseEntity.ok(categories) ;
		
	}
	
	
	
	

}

