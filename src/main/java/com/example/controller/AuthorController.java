package com.example.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Author;
import com.example.service.AuthorService;

@Controller
@RequestMapping("/authors")
public class AuthorController {

	@Autowired
	private AuthorService service;

	@InitBinder
	public void initBinderForm(WebDataBinder binder) {
		var dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		// input type="date"が複数ある場合、第二引数でフィールド名の指定はしない
		binder.registerCustomEditor(Date.class,
				new CustomDateEditor(dateFormat, true));
	}

	@GetMapping
	public String list(Model model) {
		model.addAttribute("authors", service.getAuthorList());
		return "authorList";
	}

	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("author", new Author());
		return "authorAdd";
	}

	@PostMapping("/add")
	public String add(
			@Valid Author author,
			Errors errors,
			Model model) {
		if(errors.hasErrors()) {
			for(ObjectError e : errors.getAllErrors()) {
				System.out.println(e);
			}
			return "authorAdd";
		}

		service.addAuthor(author);
		return "redirect:/authors";
	}

}