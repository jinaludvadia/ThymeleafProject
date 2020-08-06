package com.thymeleafdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.thymeleafdemo.model.User;
import com.thymeleafdemo.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	LoginService service;
	
	/*
	@GetMapping("/")
	public String redirect() {
		return "login";
	}*/

	@GetMapping("/login")
	public String getLoginForm() {
		return "login";
	}
	
	@GetMapping("/register")
	public String getRegistrationForm() {		
		return "register";
	}
	
	@PostMapping("/register")
	public String register(@ModelAttribute (name = "User") User user, Model model) {
		if(user.getUsername()=="" || user.getPassword() == "" || user.getEmail()=="") {
			model.addAttribute("emptyCredentials",true);
			return "register";
		}
		service.saveUser(user);
		return "login";
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute (name = "User") User user, Model model) {
		
		String username = user.getUsername();
		String password = user.getPassword();
		
		System.out.println(user);
		
		if(username=="" || password == "") {
			model.addAttribute("emptyCredentials",true);
			return "login";
		}
	
		if(service.isUserValid(username, password)) {
			model.addAttribute("name", username);
			return "home";
		}
		
		model.addAttribute("invalidCredentials",true);
		return "login";		
	}
}
