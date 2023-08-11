package com.jp.springbootH2.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jp.springbootH2.entities.User;

@RestController
@RequestMapping(value="/users")
public class UserController {
	
	@GetMapping
	public ResponseEntity<User> findAll() {
		User u = new User(1L, "maria", "maria@gmail.com", "999999", "12345");
		return ResponseEntity.ok().body(u);
	}
}
