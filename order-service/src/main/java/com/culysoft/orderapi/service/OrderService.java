package com.culysoft.orderapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.culysoft.orderapi.common.Payment;
import com.culysoft.orderapi.common.Status;
import com.culysoft.orderapi.common.TransactionRequest;
import com.culysoft.orderapi.common.TransactionResponse;
import com.culysoft.orderapi.entity.Order;
import com.culysoft.orderapi.repository.OrderRepository;

@Service
public class OrderService {
	
	private OrderRepository orderRepository;
	private RestTemplate restTemplate;

	@Autowired
	public OrderService(OrderRepository orderRepository, RestTemplate restTemplate) {
		this.orderRepository = orderRepository;
		this.restTemplate = restTemplate;
	}
	
	public TransactionResponse save(TransactionRequest request) {
		Order order = request.getOrder();
		Payment payment = request.getPayment();
		String message = "";
		
		payment.setOrder(order);
		payment.setAmount(order.getPrice());
		
		// rest call
//		Payment paymentResponse = this.restTemplate.postForObject("http://localhost:9191/payments", payment, Payment.class); // Before service registry
		Payment paymentResponse = this.restTemplate.postForObject("http://PAYMENT-SERVICE/payments", payment, Payment.class);
		
		if(paymentResponse.getStatus().equals(Status.SUCCESS)) {
			message = "Payment processing successful and order placed";
		} else {
			message = "There is a failure in payment api, order added to cart";
		}
		
		order = this.orderRepository.save(order);
		
		return new TransactionResponse(order, paymentResponse.getAmount(), paymentResponse.getTransactionId(), message);		
	}
	
//	public Order save(Order order) {
//		return this.orderRepository.save(order);
//	}
	

}
