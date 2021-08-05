package com.culysoft.paymentapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.culysoft.paymentapi.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

	Optional<Payment> findByOrderId(Long orderId);

}
