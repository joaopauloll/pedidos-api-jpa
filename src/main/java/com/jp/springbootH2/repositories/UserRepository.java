package com.jp.springbootH2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jp.springbootH2.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
