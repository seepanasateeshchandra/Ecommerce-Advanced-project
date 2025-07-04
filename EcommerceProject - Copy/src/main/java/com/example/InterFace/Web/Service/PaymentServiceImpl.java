package com.example.InterFace.Web.Service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.InterFace.Web.Entity.Order;
import com.example.InterFace.Web.Entity.OrderItem;
import com.example.InterFace.Web.Entity.Payment;
import com.example.InterFace.Web.Entity.PaymentStatus;
import com.example.InterFace.Web.Repository.OrderRepository;
import com.example.InterFace.Web.Repository.PaymentRepository;
import com.example.InterFace.Web.RequestDTO.PaymentDto;
import com.example.InterFace.Web.RequestDTO.PaymentRequest;

import com.example.InterFace.Web.Entity.*;

public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	orderServiceImpl orderServiceImpl;
	
	@Autowired
	private InventoryServiceImpl inventory;
	

	@Override
	public PaymentDto MakePayment(PaymentRequest request) {
		// TODO Auto-generated method stub
		Order order = orderRepository.findById(request.getOrderId()).orElseThrow();
		
		if(paymentRepository.findByOrderId(order.getId()).isPresent()) {
			throw new RuntimeException("Payment Already Made for the this order");
		}
		
		Payment payment = new Payment();
		payment.setOrder(order);
		payment.setAmount(request.getAmount());
		
		payment.setPaymentDate(LocalDateTime.now());
		
		
		if(order.getTotalAmount()== request.getAmount()) {
			
			
			payment.setStatus(PaymentStatus.SUCCESS);
		}else {
			
			payment.setStatus(PaymentStatus.FAILED);
			
			for(OrderItem orderItem :  order.getItems()) {
				
				Product product = orderItem.getProduct();
				
				inventory.increaseStock(product.getId(), product.getStockQuantity());
				
				
			}
			
			
			
			
		}
		
		
		paymentRepository.save(payment);
		
		return toDto(payment);
		
		
		
		
	}

	@Override
	public PaymentDto getPaymentByOrderId(Long orderId) {
		// TODO Auto-generated method stub
		
		Payment payment = paymentRepository.findByOrderId(orderId).orElseThrow();
		
		
		return toDto(payment);
	}
	
	
	private PaymentDto toDto(Payment payment) {
		
		return new PaymentDto(
				
				payment.getId(),
				payment.getOrder().getId(),
				payment.getPaymentDate(),
				payment.getAmount(),
				payment.getStatus()
				
				);
		
	}

}
