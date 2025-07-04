package com.example.InterFace.Web.RequestDTO;

public class OrderItemDto {
	
	
	private Long productId;
	
	private String productName;
	
	private int quantity;
	
	private double price;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public OrderItemDto(Long productId, String productName, int quantity, double price) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
	}

	public OrderItemDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
