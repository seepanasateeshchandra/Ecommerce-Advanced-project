package com.example.InterFace.Web.Entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Inventory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	
	@OneToOne
	@JoinColumn(name="product_id",nullable = false)
	private Product product;
	
	@Column(nullable = false)
	private int quantity;
	
	@Column
	@LastModifiedDate
	private LocalDateTime lastUpdated;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public LocalDateTime getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(LocalDateTime lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	@Override
	public String toString() {
		return "Inventory [id=" + id + ", product=" + product + ", quantity=" + quantity + ", lastUpdated="
				+ lastUpdated + "]";
	}

	public Inventory(Long id, Product product, int quantity, LocalDateTime lastUpdated) {
		super();
		this.id = id;
		this.product = product;
		this.quantity = quantity;
		this.lastUpdated = lastUpdated;
	}

	public Inventory() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
