package com.example.InterFace.Web.Entity;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Orders")
public class Order {
	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@ManyToOne
	@JoinColumn(name="user_id",nullable = false)
	private UserDetails user;
	
	@Column
	private LocalDateTime orderDate;
	
	@Column
	private double totalAmount;
	
	
	@OneToMany(mappedBy="order",cascade = CascadeType.ALL)
	private List<OrderItem> items;
	
	@OneToOne(mappedBy = "order",cascade = CascadeType.ALL)
	private Payment payment;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserDetails getUser() {
		return user;
	}

	public void setUser(UserDetails user) {
		this.user = user;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime localDateTime) {
		this.orderDate = localDateTime;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void setItems(List<OrderItem> items) {
		this.items = items;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Order(Long id, UserDetails user, LocalDateTime orderDate, double totalAmount, List<OrderItem> items,
			Payment payment) {
		super();
		this.id = id;
		this.user = user;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
		this.items = items;
		this.payment = payment;
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
