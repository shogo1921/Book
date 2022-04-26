package com.example.domain;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class Author {

	private Integer id;

	@NotBlank
	@Size(max = 30)
	private String name;

	// 対1
	@Valid
	private AuthorDetail detail;

	// 対多
	private List<Book> books;
}