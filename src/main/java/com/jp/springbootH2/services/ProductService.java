package com.jp.springbootH2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jp.springbootH2.entities.Product;
import com.jp.springbootH2.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;

	public List<Product> findAll() {
		return repository.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> user = repository.findById(id);
		return user.get();
	}

}