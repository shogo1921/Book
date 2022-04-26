package com.example.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Review;
import com.example.service.BookService;
import com.example.service.ReviewService;

@Controller
@RequestMapping("/reviews")
public class ReviewController {
	@Autowired
	private ReviewService service;

	@Autowired
	private BookService bookService;

	@GetMapping
	public String list(Model model) {
		model.addAttribute("reviews", service.getAllReviews());
		return "reviewList";
	}

	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("review", new Review());
		model.addAttribute("books", bookService.getAllBooks());
		return "reviewAdd";
	}

	@PostMapping("/add")
	public String add(
			@Valid Review review,
			Errors errors,
			Model model) {
		if(errors.hasErrors()) {
			model.addAttribute("books", bookService.getAllBooks());
			return "reviewAdd";
		}

		service.saveReview(review);
		return "redirect:/reviews";
	}

}
