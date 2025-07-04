package com.example.InterFace.Web.RequestDTO;

import java.sql.Date;
import java.time.LocalDateTime;

import com.example.InterFace.Web.Entity.PaymentStatus;

public class PaymentDto {
	
	private Long paymentId;
	
	
	private Long orderId;
	
	private LocalDateTime paymentDate;
	
	private double amount;
	
	private PaymentStatus status;

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public LocalDateTime getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDateTime paymentDate) {
		this.paymentDate = paymentDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public PaymentStatus getStatus() {
		return status;
	}

	public void setStatus(PaymentStatus status) {
		this.status = status;
	}

	public PaymentDto(Long paymentId, Long orderId, LocalDateTime paymentDate, double amount, PaymentStatus status) {
		super();
		this.paymentId = paymentId;
		this.orderId = orderId;
		this.paymentDate = paymentDate;
		this.amount = amount;
		this.status = status;
	}

	public PaymentDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
