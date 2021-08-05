package com.culysoft.orderapi.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name =  "ORDER_TB")
public class Order {

	@Id
	private Long id;
	private String name;
	private Integer quantity;
	private BigDecimal price;
}
