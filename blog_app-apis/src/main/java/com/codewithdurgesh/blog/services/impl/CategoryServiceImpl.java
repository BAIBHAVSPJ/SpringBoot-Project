package com.codewithdurgesh.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithdurgesh.blog.entities.Category;
import com.codewithdurgesh.blog.exceptions.ResourceNotFoundException;
import com.codewithdurgesh.blog.paylods.CategoryDto;
import com.codewithdurgesh.blog.repositories.CategoryRepo;
import com.codewithdurgesh.blog.services.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService {
	
    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private ModelMapper modelMapper;
	 
	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		Category categories= this.modelMapper.map(categoryDto, Category.class);
		 Category saveCategory=this.categoryRepo.save(categories);
		return this.modelMapper.map(saveCategory, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
		
		Category category= this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","Category Id",categoryId));
		category.setCategoryTitle(categoryDto.getCategoryTitle());
		category.setCategoryDescription(categoryDto.getCategoryDescription());
		
		Category updateCategory=this.categoryRepo.save(category);
	   
		
		return this.modelMapper.map(updateCategory, CategoryDto.class);
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		
		Category category=this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","CategoryId",categoryId));
		this.categoryRepo.delete(category);
		
		
		
		

	}

	@Override
	public CategoryDto getCategory(Integer categoryId) {
		Category category=this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","category Id",categoryId));
		
		return this.modelMapper.map(category, CategoryDto.class);
		
		
	}

	@Override
	public List<CategoryDto> getAllCategory() {
		
		List<Category> categories =this.categoryRepo.findAll();
		List<CategoryDto> categoryDto=categories.stream().map((category)-> this.modelMapper.map(categories, CategoryDto.class)).collect(Collectors.toList());
		
		
		
		return categoryDto;
		
	}
	

	

}
