package com.example.InterFace.Web.UserDashboardResponse;

import java.util.List;

import com.example.InterFace.Web.Entity.Order;
import com.example.InterFace.Web.Entity.Payment;
import com.example.InterFace.Web.RequestDTO.CartItemsDto;

public class UserDashboardResponse {
	
	
	private String name;
    private String email;
    private String phone;
    private List<OrderSummaryDTO> recentOrders;
    private List<CartItemsDto> cartItems;
    private PaymentDTO lastPayment;
    private AddressDTO address;
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
	public List<OrderSummaryDTO> getRecentOrders() {
		return recentOrders;
	}
	public void setRecentOrders(List<OrderSummaryDTO> recentOrders) {
		this.recentOrders = recentOrders;
	}
	public List<CartItemsDto> getCartItems() {
		return cartItems;
	}
	public void setCartItems(List<CartItemsDto> cartItems) {
		this.cartItems = cartItems;
	}
	public PaymentDTO getLastPayment() {
		return lastPayment;
	}
	public void setLastPayment(PaymentDTO lastPayment) {
		this.lastPayment = lastPayment;
	}
	
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
	public AddressDTO getAddress() {
		return address;
	}
	public void setAddress(AddressDTO address) {
		this.address = address;
	}
	public UserDashboardResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserDashboardResponse(String name, String email, String phone, List<OrderSummaryDTO> recentOrders,
			List<CartItemsDto> cartItems, PaymentDTO lastPayment, AddressDTO address) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.recentOrders = recentOrders;
		this.cartItems = cartItems;
		this.lastPayment = lastPayment;
		this.address = address;
	}
	
	
	
    
    

}
