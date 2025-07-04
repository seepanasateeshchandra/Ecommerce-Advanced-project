package com.example.InterFace.Web.Entity;

import java.sql.Date;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Table
@Entity
public class Payment {
	
	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	@JoinColumn(name="order_id",nullable=false)
	private Order order;
	@Column
	private LocalDateTime paymentDate;
	
	@ManyToOne
    @JoinColumn(name = "user_id")
    private UserDetails user;
	
	@Column
	private double amount;
	
    @Column
	@Enumerated(EnumType.STRING)
	private PaymentStatus status;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
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
	public LocalDateTime getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(LocalDateTime paymentDate) {
		this.paymentDate = paymentDate;
	}
	public UserDetails getUser() {
		return user;
	}
	public void setUser(UserDetails user) {
		this.user = user;
	}
	public Payment(Long id, Order order, LocalDateTime paymentDate, UserDetails user, double amount,
			PaymentStatus status) {
		super();
		this.id = id;
		this.order = order;
		this.paymentDate = paymentDate;
		this.user = user;
		this.amount = amount;
		this.status = status;
	}
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
    
}
