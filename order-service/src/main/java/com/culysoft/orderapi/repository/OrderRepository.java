package com.culysoft.orderapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.culysoft.orderapi.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
