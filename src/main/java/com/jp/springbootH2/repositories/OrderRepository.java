package com.jp.springbootH2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jp.springbootH2.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
