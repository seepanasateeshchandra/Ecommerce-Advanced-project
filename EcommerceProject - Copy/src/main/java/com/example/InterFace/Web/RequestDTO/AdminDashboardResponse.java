package com.example.InterFace.Web.RequestDTO;

import java.math.BigDecimal;

public class AdminDashboardResponse {
	
	private Long totalUsers;
	
	private long totalProducts;
	
	
	private Long totalOrders;
	
	private BigDecimal totalRevenue;
	
	
	private Long lowstockCount;


	public Long getTotalUsers() {
		return totalUsers;
	}


	public void setTotalUsers(Long totalUsers) {
		this.totalUsers = totalUsers;
	}


	public long getTotalProducts() {
		return totalProducts;
	}


	public void setTotalProducts(long totalProducts) {
		this.totalProducts = totalProducts;
	}


	public Long getTotalOrders() {
		return totalOrders;
	}


	public void setTotalOrders(Long totalOrders) {
		this.totalOrders = totalOrders;
	}


	public BigDecimal getTotalRevenue() {
		return totalRevenue;
	}


	public void setTotalRevenue(BigDecimal totalRevenue) {
		this.totalRevenue = totalRevenue;
	}


	public Long getLowstockCount() {
		return lowstockCount;
	}


	public void setLowstockCount(Long lowstockCount) {
		this.lowstockCount = lowstockCount;
	}


	public AdminDashboardResponse(Long totalUsers, long totalProducts, Long totalOrders, BigDecimal totalRevenue,
			Long lowstockCount) {
		super();
		this.totalUsers = totalUsers;
		this.totalProducts = totalProducts;
		this.totalOrders = totalOrders;
		this.totalRevenue = totalRevenue;
		this.lowstockCount = lowstockCount;
	}


	public AdminDashboardResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
