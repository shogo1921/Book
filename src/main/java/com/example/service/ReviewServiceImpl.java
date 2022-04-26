package com.example.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Review;
import com.example.domain.Reviewer;
import com.example.mapper.ReviewMapper;

@Transactional
@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private HttpSession session;

	@Autowired
	private ReviewMapper mapper;

	@Override
	public List<Review> getAllReviews() {
		return mapper.findAll();
	}

	@Override
	public void saveReview(Review review) {
		Reviewer reviewer = (Reviewer) session.getAttribute("reviewer");
		review.setReviewer(reviewer);
		mapper.save(review);
	}

}