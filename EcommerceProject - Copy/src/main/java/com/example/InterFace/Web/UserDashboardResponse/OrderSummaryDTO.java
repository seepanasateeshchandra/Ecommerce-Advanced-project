package com.example.InterFace.Web.UserDashboardResponse;

import java.time.LocalDateTime;
import java.util.List;

public class OrderSummaryDTO {
	
	
	private Long orderId;
    private LocalDateTime orderDate;
    private Double totalAmount;
    private List<String> productNames;
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public LocalDateTime getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public List<String> getProductNames() {
		return productNames;
	}
	public void setProductNames(List<String> productNames) {
		this.productNames = productNames;
	}
	public OrderSummaryDTO(Long orderId, LocalDateTime orderDate, Double totalAmount, List<String> productNames) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
		this.productNames = productNames;
	}
	public OrderSummaryDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
    

}
