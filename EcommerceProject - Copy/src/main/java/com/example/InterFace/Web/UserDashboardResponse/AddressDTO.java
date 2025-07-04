package com.example.InterFace.Web.UserDashboardResponse;

import jakarta.persistence.Column;

public class AddressDTO {
	
	
private Long addressId;
	
	
	private String streetName;
	
	
	private String doorNo;
	
	
	private String state;
	
	
	private String pincode;
	
	
	private String country;


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


	public AddressDTO(Long addressId, String streetName, String doorNo, String state, String pincode, String country) {
		super();
		this.addressId = addressId;
		this.streetName = streetName;
		this.doorNo = doorNo;
		this.state = state;
		this.pincode = pincode;
		this.country = country;
	}


	public AddressDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
