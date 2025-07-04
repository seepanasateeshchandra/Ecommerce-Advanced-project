package com.example.InterFace.Web.RequestDTO;

public class InventoryRequestDTO {
	
	private Long productId;
	
	private int quantity;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "InventoryRequestDTO [productId=" + productId + ", quantity=" + quantity + "]";
	}

	public InventoryRequestDTO(Long productId, int quantity) {
		super();
		this.productId = productId;
		this.quantity = quantity;
	}

	public InventoryRequestDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
