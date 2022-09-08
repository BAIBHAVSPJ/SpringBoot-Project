package com.codewithdurgesh.blog.services;

import java.util.List;


import com.codewithdurgesh.blog.paylods.PostDto;
import com.codewithdurgesh.blog.paylods.PostResponse;

public interface PostService {
	
	//create
	public PostDto createPost(PostDto postDto ,Integer userId,Integer catergoryId);
	
	//update
	
	public PostDto updatePost(PostDto postDto,Integer postId);
	
	//delete
	
	public void deletePost(Integer postId);
	
	//get All post
	
	public PostResponse getAllPost(Integer pageNumber,Integer pageSize,String SortBy,String sortDir);
	
	
	//get Single post
	 
	public PostDto getPostById(Integer postId);
	
	
	// get All post by category
	
	public List<PostDto> getPostsByCategory(Integer categoryId );
	
	
	//get all posts by user
	
	public List<PostDto> getPostByUser(Integer userId);
	
	// get  search post
	
	public List<PostDto>searchPosts(String keywords);
	
	
	
	
	

}
