package com.jp.springbootH2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jp.springbootH2.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
