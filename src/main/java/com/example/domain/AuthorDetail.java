package com.example.domain;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class AuthorDetail {

	private Integer id;

	@NotBlank
	@Size(max = 255)
	private String introduction;
	private Date bornAt;
	private Date diedAt;

}

