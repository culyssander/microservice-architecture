package com.culysoft.orderapi.common;

import java.math.BigDecimal;
import java.util.UUID;

import com.culysoft.orderapi.entity.Order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Payment {

	private Long id;
	private Status status;
	private UUID transactionId;
	private Order order;
	private BigDecimal amount;
}
