package com.codewithdurgesh.blog.paylods;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class PostResponse {
	
	
	private List<PostDto> content;
	
	private int pageNumber;
	
	private int pageSize;
	
	private long totalElement;
	
	private int totalPages;
	
	private boolean lastPages;

}