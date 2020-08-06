package com.thymeleafdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thymeleafdemo.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,String>{
	User findByUsername(String username);
	
	User save(User user);
}
