package com.example.InterFace.Web.Service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.InterFace.Web.Repository.OrderItemRepository;
import com.example.InterFace.Web.Repository.OrderRepository;
import com.example.InterFace.Web.Repository.PaymentRepository;
import com.example.InterFace.Web.Repository.ProductRepository;
import com.example.InterFace.Web.Repository.UserRepository;
import com.example.InterFace.Web.RequestDTO.AdminDashboardResponse;

@Service
public class AdminDashBoardService {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	

	public AdminDashboardResponse getDashboardDetails() {
		
		AdminDashboardResponse response = new AdminDashboardResponse();
		
		response.setTotalUsers(userRepository.count());
		
		response.setTotalOrders(orderRepository.count());
		
		response.setTotalProducts(productRepository.count());
		
		BigDecimal totalRevenue = paymentRepository.getTotalRevenue();
		
		response.setTotalRevenue(totalRevenue);
		
		long lowStock = productRepository.countByStockQuantityLessThan(5);
		
		response.setLowstockCount(lowStock);
		
		
		return response;
	}
	
	

}
