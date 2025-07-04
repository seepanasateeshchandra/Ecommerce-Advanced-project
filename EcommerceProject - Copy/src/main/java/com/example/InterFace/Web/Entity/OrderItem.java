package com.example.InterFace.Web.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Table
@Entity
public class OrderItem {
	
	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="order_id,nullable=false")
	private Order order;
	
	@ManyToOne
	@JoinColumn(name="product_id",nullable=false)
	private Product product;
	
	@Column
	private int quantity;
	@Column
	private double price;
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
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", order=" + order + ", product=" + product + ", quantity=" + quantity
				+ ", price=" + price + "]";
	}
	public OrderItem(Long id, Order order, Product product, int quantity, double price) {
		super();
		this.id = id;
		this.order = order;
		this.product = product;
		this.quantity = quantity;
		this.price = price;
	}
	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

}
