package com.devsuperior.dscommerce.dto;

import com.devsuperior.dscommerce.entities.OrderItem;

public class OrderItemDTO {

	private Long id;
	private String name;
	private Double price;
	private Integer quantity;
	
	public OrderItemDTO(Long id, String name, Double price, Integer quantity) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	
	public OrderItemDTO(OrderItem entity) {
		id = entity.getProduct().getId();
		name = entity.getProduct().getName();
		price = entity.getPrice();
		quantity = entity.getQuantity();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Double getPrice() {
		return price;
	}

	public Integer getQuantity() {
		return quantity;
	}
		
	public Double getSubTotal() {
		return price * quantity;
	}

	/* MÉTODO ACRESCENTADO PARA RESOLVER O OrderServuce.java na LINHA 56
	 * PORQUE NÃO ESTAVA RETORNANDO .getReferenceById(itemDto.getProducId())
	 * É provável que isso resultará em um erro futuro...*/
	public Long getProducId() {
		return id;
	}
}
