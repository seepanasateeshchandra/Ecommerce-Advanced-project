package com.example.InterFace.Web.RequestDTO;

import java.util.List;

import com.example.InterFace.Web.Entity.Address;
import com.example.InterFace.Web.Entity.Order;
import com.example.InterFace.Web.Entity.Payment;

public class UserDashboardDTO {
	
	private String name;
	
	private String email;
	
	private String role;
	
	private List<OrderDto> recentOrders;
	
	private List<CartItemsDto> cartItems;
	
	private PaymentSummaryDTO lastPayment;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<OrderDto> getRecentOrders() {
		return recentOrders;
	}

	public void setRecentOrders(List<OrderDto> recentOrders) {
		this.recentOrders = recentOrders;
	}

	public List<CartItemsDto> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItemsDto> cartItems) {
		this.cartItems = cartItems;
	}

	public PaymentSummaryDTO getLastPayment() {
		return lastPayment;
	}

	public void setLastPayment(PaymentSummaryDTO lastPayment) {
		this.lastPayment = lastPayment;
	}

	public UserDashboardDTO(String name, String email, String role, List<OrderDto> recentOrders,
			List<CartItemsDto> cartItems, PaymentSummaryDTO lastPayment) {
		super();
		this.name = name;
		this.email = email;
		this.role = role;
		this.recentOrders = recentOrders;
		this.cartItems = cartItems;
		this.lastPayment = lastPayment;
	}

	public UserDashboardDTO(String string, String string2, String string3, List<Order> recentOrders2, List<CartItemsDto> cartItems2, Payment payment, Address address) {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
