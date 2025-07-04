package com.example.InterFace.Web.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Table
@Entity
public class Address {
	
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long addressId;
	
	@Column
	private String streetName;
	
	@Column
	private String doorNo;
	
	@Column
	private String state;
	
	@Column
	private String pincode;
	
	@Column
	private String country;
	
	@OneToOne
	@JoinColumn(name="user_id")
	private UserDetails user;

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getDoorNo() {
		return doorNo;
	}

	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public UserDetails getUser() {
		return user;
	}

	public void setUser(UserDetails user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", streetName=" + streetName + ", doorNo=" + doorNo + ", state="
				+ state + ", pincode=" + pincode + ", country=" + country + ", user=" + user + "]";
	}

	public Address(Long addressId, String streetName, String doorNo, String state, String pincode, String country,
			UserDetails user) {
		super();
		this.addressId = addressId;
		this.streetName = streetName;
		this.doorNo = doorNo;
		this.state = state;
		this.pincode = pincode;
		this.country = country;
		this.user = user;
	}

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
