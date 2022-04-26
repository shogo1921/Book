package com.example.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.domain.Reviewer;
import com.example.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService service;

	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("reviewer", new Reviewer());
		return "login";
	}

	@PostMapping("/login")
	public String login(
			HttpSession session,
			@Valid Reviewer reviewer,
			Errors errors,
			Model model) {
		if(errors.hasErrors()) {
			return "login";
		}

		Reviewer loginReviewer = service.getLoginReviewer(reviewer.getLoginId(), reviewer.getLoginPass());

		if(loginReviewer == null) {
			model.addAttribute("errorLogin", "ログインIDまたはパスワードが正しくありません");
			return "login";
		}

		session.setAttribute("reviewer", loginReviewer);
		return "redirect:/reviews/add";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/home";
	}

}