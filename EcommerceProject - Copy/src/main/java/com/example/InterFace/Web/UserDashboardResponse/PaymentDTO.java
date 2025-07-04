package com.example.InterFace.Web.UserDashboardResponse;

import java.time.LocalDateTime;

import com.example.InterFace.Web.Entity.PaymentStatus;

public class PaymentDTO {
	
	private Long paymentId;
    private LocalDateTime paymentDate;
    private double amount;
   
    public PaymentStatus getStatus() {
		return status;
	}
	public void setStatus(PaymentStatus status) {
		this.status = status;
	}
	private PaymentStatus status;
	public Long getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
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
	
	public PaymentDTO(Long paymentId, LocalDateTime paymentDate, double amount, PaymentStatus status) {
		super();
		this.paymentId = paymentId;
		this.paymentDate = paymentDate;
		this.amount = amount;
		
		this.status = status;
	}
	public PaymentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    

}
