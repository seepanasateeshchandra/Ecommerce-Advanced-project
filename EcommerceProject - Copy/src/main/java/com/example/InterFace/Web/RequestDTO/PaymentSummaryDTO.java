package com.example.InterFace.Web.RequestDTO;

import java.time.LocalDateTime;

public class PaymentSummaryDTO {
	
	private Long paymentId;
	
	private Double amount;
	
	private String paymentStatus;
	
	private LocalDateTime paymentDate;

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public LocalDateTime getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDateTime paymentDate) {
		this.paymentDate = paymentDate;
	}

	public PaymentSummaryDTO(Long paymentId, Double amount, String paymentStatus, LocalDateTime paymentDate) {
		super();
		this.paymentId = paymentId;
		this.amount = amount;
		this.paymentStatus = paymentStatus;
		this.paymentDate = paymentDate;
	}

	public PaymentSummaryDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
