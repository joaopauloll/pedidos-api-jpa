package com.jp.springbootH2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jp.springbootH2.entities.Product;
import com.jp.springbootH2.services.ProductService;

@RestController
@RequestMapping(value="/products")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@GetMapping
	public ResponseEntity<List<Product>> getAll() {
		List<Product> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Product> getById(@PathVariable Long id) {
		Product user = service.findById(id);
		return ResponseEntity.ok().body(user);
	}
}
