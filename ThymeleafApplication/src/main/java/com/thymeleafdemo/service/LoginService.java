package com.thymeleafdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thymeleafdemo.model.User;
import com.thymeleafdemo.repository.UserRepository;

@Service
public class LoginService {

	@Autowired
	UserRepository repository;
	
	public boolean isUserValid(String username, String password) {
		User user = repository.findByUsername(username);
		System.out.println(user);
		if(username.equals(user.getUsername()) && password.equals(user.getPassword())) {
			return true;
		}
		return false;
	}
	
	public void saveUser(User user) {
		repository.save(user);
	}
}
