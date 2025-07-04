package com.example.InterFace.Web.RequestDTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class ProductDto {
	
	private Long id;
	
	@NotBlank(message = "Product name is required")
	private String name;
	
	@NotBlank(message = "Description is required")
	private String description;
	
	@Positive(message = "Price must be greater than zero")
	private double price;
	
	@NotBlank(message="category is required")
	private String category;
	
	@Min(value=0,message="Stock must be zero or positive")
	private int stockQuantity;


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


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public int getStockQuantity() {
		return stockQuantity;
	}


	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}


	


	public ProductDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ProductDto(Long id, String name, double price,int stockQuantity, String description, String category) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.category = category;
		this.stockQuantity = stockQuantity;
	}


	
	
	

}
