package com.culysoft.orderapi.common;

import com.culysoft.orderapi.entity.Order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TransactionRequest {
	
	private Order order;
	private Payment payment;

}
