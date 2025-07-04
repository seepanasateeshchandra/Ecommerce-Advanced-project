package com.example.InterFace.Web.RequestDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UserDTO {
	
	@NotBlank(message="Full name is required")
	private String name;
	
	@Email(message="Enter a valid email")
	private String emailId;
	
	@Size(min=6,message="Password must be at least 6 characters")
	private String password;
	
	@NotBlank(message = "Role is required")
	private String role;
	
	@Pattern(regexp = "\\d{10}",message="Phone must be 10 digits")
	private String phoneNumber;
	
	@NotBlank(message = "Gender is required")
	private String gender;
	
	

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserDTO(String name, String emailId, String password, String role, String phoneNumber, String gender) {
		super();
		this.name = name;
		this.emailId = emailId;
		this.password = password;
		this.role = role;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
	}

	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "UserDTO [name=" + name + ", emailId=" + emailId + ", password=" + password + ", role=" + role
				+ ", phoneNumber=" + phoneNumber + ", gender=" + gender + "]";
	}

	

	
	
	
	
	
	
	

}
