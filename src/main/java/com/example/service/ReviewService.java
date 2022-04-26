package com.example.service;

import java.util.List;

import com.example.domain.Review;

public interface ReviewService {

	List<Review> getAllReviews();
	void saveReview(Review review);
}
