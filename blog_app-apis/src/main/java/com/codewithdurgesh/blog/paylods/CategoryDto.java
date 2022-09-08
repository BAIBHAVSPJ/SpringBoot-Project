package com.codewithdurgesh.blog.paylods;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter

public class CategoryDto {
	
	
	private Integer categoryId;
	@NotEmpty
	@Size(min=10,message="user must be of 10 character")
	private String categoryTitle;
	
	@NotEmpty
	@Size(min =3,max=10,message="password must be min of 3 chars and max of 10 chars !!")
	private String categoryDescription;
	
	
}
