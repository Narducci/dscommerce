package com.devsuperior.dscommerce.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.devsuperior.dscommerce.entities.Order;
import com.devsuperior.dscommerce.entities.OrderItem;
import com.devsuperior.dscommerce.entities.OrderStatus;

public class OrderDTO {

	private Long id;
	private Instant momment;
	private OrderStatus status;
	
	private ClienteDTO client;
	private PaymentDTO payment;
	private List<OrderItemDTO> items = new ArrayList<>();
	public OrderDTO(Long id, Instant momment, OrderStatus status, ClienteDTO client, PaymentDTO payment) {
		this.id = id;
		this.momment = momment;
		this.status = status;
		this.client = client;
		this.payment = payment;
	}
	public OrderDTO(Order entity) {
		id = entity.getId();
		momment = entity.getMoment();
		status = entity.getStatus();
		client = new ClienteDTO(entity.getClient());
		payment = (entity.getPayment() == null) ? null : new PaymentDTO(entity.getPayment());
		for (OrderItem item : entity.getItems()) {
			OrderItemDTO itemDto = new OrderItemDTO(item);
			items.add(itemDto);
		}
	}
	public Long getId() {
		return id;
	}
	public Instant getMomment() {
		return momment;
	}
	public OrderStatus getStatus() {
		return status;
	}
	public ClienteDTO getClient() {
		return client;
	}
	public PaymentDTO getPayment() {
		return payment;
	}
	public List<OrderItemDTO> getItems() {
		return items;
	}
	
	public Double getTotal() {
		double sum = 0.0;
		for (OrderItemDTO item : items) {
			sum += item.getSubTotal();
		}
		return sum;
	}
}
