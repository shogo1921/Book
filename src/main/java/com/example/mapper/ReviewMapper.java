package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.domain.Review;

@Mapper
public interface ReviewMapper {

	List<Review> findAll();
	void save(Review review);

}