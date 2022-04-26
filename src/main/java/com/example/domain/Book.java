package com.example.domain;

import java.util.List;

import lombok.Data;

@Data
public class Book {

	private Integer id;
	private String title;
	private Integer authorId;
	private String publisher;
	private Integer price;

	// 対1
	private Author author;

	// 対多
	private List<Review> review;

}