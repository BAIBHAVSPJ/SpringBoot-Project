package com.codewithdurgesh.blog.services;

import java.util.List;

import com.codewithdurgesh.blog.paylods.CategoryDto;

public interface CategoryService {
	
	//create user
	public CategoryDto createCategory(CategoryDto category);
	
	
	
	//update user
	public CategoryDto updateCategory(CategoryDto category,Integer categoryId);
	
	
	
	
	//delete user
	public void deleteCategory(Integer categoryId);
	
	
	
	//get user
	public CategoryDto getCategory(Integer categoryId);
	
	
	
	
	
	
	
	//get all user
	
	public List<CategoryDto>getAllCategory();
	
	
	
	

}
