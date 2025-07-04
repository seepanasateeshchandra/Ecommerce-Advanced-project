package com.example.InterFace.Web.RequestDTO;

public class CartItemsDto {
	
	private Long productId;
	
	private String productName;
	
	private double price;
	
	private int quantity;

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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "CartItemsDto [productId=" + productId + ", productName=" + productName + ", price=" + price
				+ ", quantity=" + quantity + "]";
	}

	public CartItemsDto(Long productId, String productName, double price, int quantity) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
	}

	public CartItemsDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
