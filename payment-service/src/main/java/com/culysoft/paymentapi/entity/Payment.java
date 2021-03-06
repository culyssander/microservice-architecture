package com.culysoft.paymentapi.entity;

import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "PAYMENT_TB")
public class Payment {
	
	@Id
	@GeneratedValue
	private Long id;
	@Enumerated(EnumType.STRING)
	private Status status;
	private UUID transactionId;
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "order_id")
	private Order order;
	private BigDecimal amount;
	
}
