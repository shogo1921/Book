package com.example.domain;

import java.util.List;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class Reviewer {

	private Integer id;
	private String name;

	@NotBlank
	private String loginId;
	private String loginPass;

	// 対多
	private List<Review> review;

}