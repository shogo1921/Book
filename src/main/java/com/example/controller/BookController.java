package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.service.AuthorService;
import com.example.service.BookService;

@Controller
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService service;

	@Autowired
	private AuthorService authorService;

	@GetMapping
	public String list(Model model) {
		model.addAttribute("books", service.getAllBooks());
		return "bookList";
	}

	@GetMapping("/byAuthor/{authorId}")
	public String byAuthor(
			@PathVariable Integer authorId,
			Model model) {
		System.out.println(authorService.getAuthorById(authorId));
		model.addAttribute("author", authorService.getAuthorById(authorId));
		return "booksByAuthor";
	}
}
