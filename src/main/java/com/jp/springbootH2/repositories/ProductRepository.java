package com.jp.springbootH2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jp.springbootH2.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
