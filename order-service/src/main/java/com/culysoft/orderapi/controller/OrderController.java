package com.culysoft.orderapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.culysoft.orderapi.common.TransactionRequest;
import com.culysoft.orderapi.common.TransactionResponse;
import com.culysoft.orderapi.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

	private OrderService orderService;

	@Autowired
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@PostMapping
	public TransactionResponse bookOrder(@RequestBody TransactionRequest request) {
		return this.orderService.save(request);
	}
	
	//old idea	
//	@PostMapping
//	public Order bookOrder(@RequestBody Order order) {
//		return this.orderService.save(order);
//	}
	
}
 