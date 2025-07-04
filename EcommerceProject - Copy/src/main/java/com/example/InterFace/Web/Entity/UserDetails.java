package com.example.InterFace.Web.Entity;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class UserDetails implements org.springframework.security.core.userdetails.UserDetails {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String name;
	
	@Column(unique = true)
	private String emailId;
	
	@Column
	private String password;
	
	@Column
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@OneToOne(mappedBy="user",cascade = CascadeType.ALL)
	private Cart cart;
	
	@OneToMany(mappedBy="user",cascade = CascadeType.ALL)
	private List<Order> orders;
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	private List<Payment>  payments;
	
	
	@Column
	private String phone;
	
	@OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
	private Address address;
	
	@Column
	private String gender;
	
	
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return emailId;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}


	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public UserDetails(Long id, String name, String emailId, String password, Role role, Cart cart, List<Order> orders,
			List<Payment> payments, String phone, Address address,String gender) {
		super();
		this.id = id;
		this.name = name;
		this.emailId = emailId;
		this.password = password;
		this.role = role;
		this.cart = cart;
		this.orders = orders;
		this.payments = payments;
		this.phone = phone;
		this.address = address;
		this.gender = gender;
	}

	public UserDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
