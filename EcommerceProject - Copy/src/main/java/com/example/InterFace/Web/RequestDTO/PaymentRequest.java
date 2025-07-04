package com.example.InterFace.Web.RequestDTO;

public class PaymentRequest {
	
	private Long orderId;
	
	private double amount;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public PaymentRequest(Long orderId, double amount) {
		super();
		this.orderId = orderId;
		this.amount = amount;
	}

	public PaymentRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
