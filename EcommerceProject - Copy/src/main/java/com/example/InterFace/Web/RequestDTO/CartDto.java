package com.example.InterFace.Web.RequestDTO;

import java.util.List;

public class CartDto {
	
	private Long userId;
	
	private List<CartItemsDto> items;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public List<CartItemsDto> getItems() {
		return items;
	}

	public void setItems(List<CartItemsDto> items) {
		this.items = items;
	}

	public CartDto(Long userId, List<CartItemsDto> items) {
		super();
		this.userId = userId;
		this.items = items;
	}

	public CartDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CartDto [userId=" + userId + ", items=" + items + "]";
	}
	
	

}
