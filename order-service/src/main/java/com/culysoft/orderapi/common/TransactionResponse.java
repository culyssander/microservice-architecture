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
public class TransactionResponse {

	private Order order;
	private BigDecimal amount;
	private UUID transactionId;
	private String message;
	
}
