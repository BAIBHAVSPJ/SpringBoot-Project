package com.codewithdurgesh.blog.services.impl;


import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.codewithdurgesh.blog.entities.Category;
import com.codewithdurgesh.blog.entities.Post;
import com.codewithdurgesh.blog.entities.User;
import com.codewithdurgesh.blog.exceptions.ResourceNotFoundException;
import com.codewithdurgesh.blog.paylods.PostDto;
import com.codewithdurgesh.blog.paylods.PostResponse;
import com.codewithdurgesh.blog.repositories.CategoryRepo;
import com.codewithdurgesh.blog.repositories.PostRepo;
import com.codewithdurgesh.blog.repositories.UserRepo;
import com.codewithdurgesh.blog.services.PostService;
@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostRepo postRepo;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private CategoryRepo categoryRepo;

	@Override
	public PostDto createPost(PostDto postDto,Integer userId,Integer categoryId) {
		
		
	User user=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","id",userId));
	Category category= this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","Category Id",categoryId));
			
		
	Post post =	this.modelMapper.map(postDto, Post.class);
	post.setImageName("default.png");
	post.setAddDate(new Date());
	post.setUser(user);
	post.setCategory(category);
	
	Post savePost=this.postRepo.save(post);
	
	
		return this.modelMapper.map(savePost, PostDto.class);
	}

	@Override
	public PostDto updatePost(PostDto postDto,Integer postId) {
    Post post=this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post","Post Id",postId));
         post.setContent(postDto.getContent());
         post.setTitle(postDto.getTitle());
         post.setImageName(postDto.getImageName());
        Post postUpdate= this.postRepo.save(post);
    
		return this.modelMapper.map(postUpdate, PostDto.class);
	}

	@Override
	public void deletePost(Integer postId) {
		Post Post=this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post","Post Id",postId));
                 this.postRepo.delete(Post);
	}

	@Override
	public PostResponse getAllPost(Integer pageNumber,Integer pageSize,String sortBy,String sortDir) {
		Sort sort=null;
		if(sortDir.equalsIgnoreCase("asc")) {
			sort =Sort.by(sortBy).ascending();
		}else {
			sort =Sort.by(sortBy).descending();
		}
		Pageable p = PageRequest.of(pageSize, pageNumber, sort);
		Page<Post> pagePost = this.postRepo.findAll(p);
	    List<Post> allPost = pagePost.getContent();
	   //  List<Post> allPost=pagePost.getContent();
		
		//List<Post> allPost=this.postRepo.findAll();
		List<PostDto> postDtos=allPost.stream().map((post)-> this.modelMapper.map(allPost, PostDto.class)).collect(Collectors.toList());
		
		PostResponse postResponse =new PostResponse();
		postResponse.setContent(postDtos);
		postResponse.setPageSize(pagePost.getNumber());
		postResponse.setPageSize(pagePost.getSize());
		postResponse.setTotalElement(pagePost.getTotalElements());
		postResponse.setTotalPages(pagePost.getTotalPages());
		postResponse.setLastPages(pagePost.isLast());
		
		return postResponse;
	}

	@Override
	public PostDto getPostById(Integer postId) {
		
		Post post=this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post","Post Id",postId));
		
		PostDto postSaved=this.modelMapper.map(post,PostDto.class);
		
		
		return postSaved;
		
		
	}

	@Override
	public List<PostDto> getPostsByCategory(Integer categoryId) {
		
		Category category = this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","Category Id",categoryId));
		List<Post> posts=this.postRepo.findByCategory(category);
		List<PostDto> postDtos=posts.stream().map((post)-> this.modelMapper.map(post,PostDto.class)).collect(Collectors.toList());
		return postDtos;
		
	}

	@Override
	public List<PostDto> getPostByUser(Integer userId) {
	User user=	this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","id",userId));
	List<Post> posts=this.postRepo.findByUser(user);
	List<PostDto> postDtos=posts.stream().map((post)-> this.modelMapper.map(post,PostDto.class)).collect(Collectors.toList());
		
		return postDtos;
	}

	@Override
	public List<PostDto> searchPosts(String keywords) {
		List<Post> posts = this.postRepo.findByTitleContaining(keywords);
		List<PostDto> collect = posts.stream().map((post)->this.modelMapper.map(posts, PostDto.class)).collect(Collectors.toList());
		
		return collect ;
	}

}
