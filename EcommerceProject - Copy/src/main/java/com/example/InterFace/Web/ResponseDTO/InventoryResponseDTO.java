package com.example.InterFace.Web.ResponseDTO;

import java.time.LocalDateTime;

public class InventoryResponseDTO {
	
	private Long id;
	
	private String productName;
	
	private int quantity;
	
	private LocalDateTime lastUpdated;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
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
		return "InventoryResponseDTO [id=" + id + ", productName=" + productName + ", quantity=" + quantity
				+ ", lastUpdated=" + lastUpdated + "]";
	}

	public InventoryResponseDTO(Long id, String productName, int quantity, LocalDateTime lastUpdated) {
		super();
		this.id = id;
		this.productName = productName;
		this.quantity = quantity;
		this.lastUpdated = lastUpdated;
	}

	public InventoryResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
