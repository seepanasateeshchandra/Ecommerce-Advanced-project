package com.example.InterFace.Web.Service;

import java.util.List;

import com.example.InterFace.Web.RequestDTO.OrderDto;

public interface OrderService {
	
	
	OrderDto placeOrder(Long userId);
	
	List<OrderDto> getUserOrders(Long userId);
	
	OrderDto getOrderById(Long orderId);
	
	
	
	

}
