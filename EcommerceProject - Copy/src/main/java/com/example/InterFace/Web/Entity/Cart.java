package com.example.InterFace.Web.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Cart {
	
	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	@JoinColumn(name="user_id",nullable=false)
	private UserDetails user;
	
	@OneToMany(mappedBy="cart",cascade = CascadeType.ALL)
	private List<CartItem> items;
	
	@Column
	private double totalPrice;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserDetails getUser() {
		return user;
	}

	public void setUser(UserDetails user) {
		this.user = user;
	}

	public List<CartItem> getItems() {
		return items;
	}

	public void setItems(List<CartItem> items) {
		this.items = items;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Cart(Long id, UserDetails user, List<CartItem> items, double totalPrice) {
		super();
		this.id = id;
		this.user = user;
		this.items = items;
		this.totalPrice = totalPrice;
	}

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", user=" + user + ", items=" + items + ", totalPrice=" + totalPrice + "]";
	}

	
	
	
	
	

}
