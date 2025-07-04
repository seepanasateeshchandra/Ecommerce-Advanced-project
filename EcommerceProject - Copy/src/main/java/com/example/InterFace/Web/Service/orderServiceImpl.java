package com.example.InterFace.Web.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.InterFace.Web.Entity.Order;
import com.example.InterFace.Web.ExceptionHandler.ResourceNotFoundException;
import com.example.InterFace.Web.Repository.CartRepository;
import com.example.InterFace.Web.Repository.InventoryRepository;
import com.example.InterFace.Web.Repository.OrderItemRepository;
import com.example.InterFace.Web.Repository.OrderRepository;
import com.example.InterFace.Web.Repository.ProductRepository;
import com.example.InterFace.Web.RequestDTO.OrderDto;
import com.example.InterFace.Web.RequestDTO.OrderItemDto;

import com.example.InterFace.Web.Entity.*;

import java.util.*;

@Service
public class orderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	
	
	@Autowired
	private InventoryServiceImpl inventory;
	
	
	
	
	
	
	
	
	

	@Override
	public OrderDto placeOrder(Long userId) {
		// TODO Auto-generated method stub
	
		Cart cart = cartRepository.findByUserId(userId).orElseThrow();
		
		if(cart.getItems().isEmpty()) throw new RuntimeException("Cart Is Empty !");
		
		Order order = new Order();
		
		order.setUser(cart.getUser());
		
		order.setOrderDate(LocalDateTime.now());
		
		List<OrderItem> items = new ArrayList<>();
		
		double total = 0;
		
		for(CartItem cItem : cart.getItems()) {
			
			Product product = cItem.getProduct();
			
			if(inventory.checkAvailability(product.getId(), product.getStockQuantity())); OrderItem oItem = new OrderItem();
			
			
			
			oItem.setOrder(order);
			oItem.setProduct(product);
			
			oItem.setQuantity(cItem.getQuantity());
			
			oItem.setPrice(product.getPrice());
			
			total += product.getPrice() * cItem.getQuantity();
			
			inventory.reduceStock(product.getId(), product.getStockQuantity());
			
			items.add(oItem);
			
			
		}
		
		order.setTotalAmount(total);
		
		
		order.setItems(items);
		
		orderRepository.save(order);
		
		
		
		cart.getItems().clear();
		
		cartRepository.save(cart);
		
		return toDTo(order);
		
		
		
		
		
		
		
		
		
	}

	@Override
	public List<OrderDto> getUserOrders(Long userId) {
		
		return orderRepository.findByUserId(userId).stream().map(this::toDTo).collect(Collectors.toList());
	}

	@Override
	public OrderDto getOrderById(Long orderId) {
		return toDTo(orderRepository.findById(orderId).orElseThrow());
	}
	
	
	private OrderDto toDTo(Order order) {
		
		
		List<OrderItemDto> itemDto = order.getItems().stream().map(i-> new OrderItemDto(
				
				
				i.getProduct().getId(),i.getProduct().getName(),i.getQuantity(),i.getPrice())).toList();
		
	
	
	
	return new OrderDto(
			
			order.getId(),
			order.getUser().getId(),
			order.getOrderDate(),
			order.getTotalAmount(),
			itemDto
			);
			

}
	
	
	
	    
	
	
	
	
	
}
	    
	
