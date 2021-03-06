package com.culysoft.paymentapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.culysoft.paymentapi.entity.Payment;
import com.culysoft.paymentapi.service.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentController {

	private PaymentService paymentService;

	public PaymentController(PaymentService paymentService) {
		this.paymentService = paymentService;
	}
	
	@GetMapping("/{orderId}")
	public Payment findByOrderId(@PathVariable Long orderId) {
		return this.paymentService.findByOrderId(orderId);
	}
	
	@PostMapping
	public Payment doPayment(@RequestBody Payment payment) {
		return this.paymentService.doPayment(payment);
	}
	
	
}
