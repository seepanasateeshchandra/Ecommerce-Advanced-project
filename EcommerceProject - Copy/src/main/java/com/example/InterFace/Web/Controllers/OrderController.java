package com.example.InterFace.Web.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.InterFace.Web.RequestDTO.OrderDto;

import com.example.InterFace.Web.Service.orderServiceImpl;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
	
	@Autowired
	private orderServiceImpl orderService;
	
	@PostMapping("/{userId}")
    public ResponseEntity<OrderDto> placeOrder(@PathVariable Long userId) {
        return ResponseEntity.ok(orderService.placeOrder(userId));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<OrderDto>> getOrders(@PathVariable Long userId) {
        return ResponseEntity.ok(orderService.getUserOrders(userId));
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable Long orderId) {
        return ResponseEntity.ok(orderService.getOrderById(orderId));
    }
	
	
	

}
