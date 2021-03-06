package com.culysoft.paymentapi.service;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.culysoft.paymentapi.entity.Payment;
import com.culysoft.paymentapi.entity.Status;
import com.culysoft.paymentapi.exception.PaymentNotFoundException;
import com.culysoft.paymentapi.repository.PaymentRepository;

@Service
public class PaymentService {

	private PaymentRepository paymentRepository;

	@Autowired
	public PaymentService(PaymentRepository paymentRepository) {
		this.paymentRepository = paymentRepository;
	}
	
	public Payment doPayment(Payment payment) {
		payment.setStatus(paymentProcessing());
		payment.setTransactionId(UUID.randomUUID());
		return this.paymentRepository.save(payment);
	}
	
	private Status paymentProcessing() {
		// api should be 3rd party payment gateway (paypal, paytm or other)
		boolean result = new Random().nextBoolean();
		return result ? Status.SUCCESS : Status.FAILURE;
	}
	
	public Payment findByOrderId(Long orderId) {
		return this.paymentRepository.findByOrderId(orderId).orElseThrow(
				() -> new PaymentNotFoundException("Paymente not found"));
	}
}
