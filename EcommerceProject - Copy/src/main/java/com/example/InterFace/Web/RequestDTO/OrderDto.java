package com.example.InterFace.Web.RequestDTO;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

public class OrderDto {
	
	private Long orderId;
	
	private Long userId;
	
	private LocalDateTime orderDate;
	
	private double totalAmount;
	
	private List<OrderItemDto> items;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public List<OrderItemDto> getItems() {
		return items;
	}

	public void setItems(List<OrderItemDto> items) {
		this.items = items;
	}

	public OrderDto(Long orderId, Long userId, LocalDateTime orderDate, double totalAmount, List<OrderItemDto> items) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
		this.items = items;
	}

	public OrderDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
