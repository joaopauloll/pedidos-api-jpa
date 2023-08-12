package com.jp.springbootH2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jp.springbootH2.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
