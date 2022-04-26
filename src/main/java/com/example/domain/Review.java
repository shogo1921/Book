package com.example.domain;

import lombok.Data;

@Data
public class Review {

	// 対1
	private Reviewer reviewer;
	private Book book;

	private Integer score;
	private String comment;

}
