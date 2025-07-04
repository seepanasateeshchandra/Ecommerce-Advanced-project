package com.example.InterFace.Web.ResponseDTO;

import java.util.List;

public class CartResponseDTO {
	
	private List<CartItemResponseDTO> items;
	private double totalPrice;
	public List<CartItemResponseDTO> getItems() {
		return items;
	}
	public void setItems(List<CartItemResponseDTO> items) {
		this.items = items;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public CartResponseDTO(List<CartItemResponseDTO> items, double totalPrice) {
		super();
		this.items = items;
		this.totalPrice = totalPrice;
	}
	public CartResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
