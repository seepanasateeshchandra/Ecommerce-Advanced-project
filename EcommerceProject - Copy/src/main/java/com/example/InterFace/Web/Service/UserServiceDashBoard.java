package com.example.InterFace.Web.Service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.InterFace.Web.Entity.Address;
import com.example.InterFace.Web.Entity.CartItem;
import com.example.InterFace.Web.Entity.Order;
import com.example.InterFace.Web.Entity.Payment;
import com.example.InterFace.Web.Entity.UserDetails;
import com.example.InterFace.Web.Repository.CartItemRepository;
import com.example.InterFace.Web.Repository.OrderRepository;
import com.example.InterFace.Web.Repository.PaymentRepository;
import com.example.InterFace.Web.Repository.UserRepository;
import com.example.InterFace.Web.RequestDTO.CartItemsDto;

import com.example.InterFace.Web.UserDashboardResponse.AddressDTO;
import com.example.InterFace.Web.UserDashboardResponse.CartItemDTO;
import com.example.InterFace.Web.UserDashboardResponse.OrderSummaryDTO;
import com.example.InterFace.Web.UserDashboardResponse.PaymentDTO;
import com.example.InterFace.Web.UserDashboardResponse.UserDashboardResponse;

@Service
public class UserServiceDashBoard {
	
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CartItemRepository cartRepository;
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	
	
	
	
	
	

	public UserDashboardResponse getUserDashBoard(String emailId) {
		
		
	
	        UserDetails user = userRepository.findByEmailId(emailId).orElseThrow(()-> new RuntimeException("User is Not found"));
	        
	        
	        List<OrderSummaryDTO>  recentOrders = orderRepository.findTop5ByUserOrderByOrderDateDesc(user).stream().map(this::toSummary).collect(Collectors.toList());
	        
	        List<CartItemsDto> cartItems = cartRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
	        
	        PaymentDTO payment =  toPayment(paymentRepository.findTopByUserOrderByPaymentDateDesc(user).get());
	        
	        AddressDTO address = toAddress(user.getAddress());
	        
	        
	        return new UserDashboardResponse(user.getName(),user.getEmailId(),user.getPhone(),recentOrders,cartItems,payment,address);
	        		
	        		
	        		
	      
	        		
	       
		
		
	}
	
	 private CartItemsDto toDTO(CartItem cart) {
		 
		 
		 CartItemsDto cartItem = new CartItemsDto();
		 
		 cartItem.setProductId(cart.getProduct().getId());
		 cartItem.setProductName(cart.getProduct().getName());
		 cartItem.setPrice(cart.getProduct().getPrice());
		 cartItem.setQuantity(cart.getProduct().getStockQuantity());
		 
		 
		 return cartItem;
     	
     	
     	
     }
	 
	 
	 private AddressDTO toAddress(Address address) {
		 
		 
		 AddressDTO Existaddress = new AddressDTO();
		 
		 Existaddress.setAddressId(address.getAddressId());
		 Existaddress.setCountry(address.getCountry());
		 Existaddress.setDoorNo(address.getDoorNo());
		 Existaddress.setPincode(address.getPincode());
		 Existaddress.setState(address.getState());
		 Existaddress.setStreetName(address.getStreetName());
		 
		 return Existaddress;
		 
		 
		 
	 }
	 
	 
	 
	 private OrderSummaryDTO toSummary(Order order) {
		 
		 OrderSummaryDTO order1 = new OrderSummaryDTO();
		 
		 order1.setOrderId(order.getId());
		 
		 order1.setOrderDate(order.getOrderDate());
		 
		 order1.setTotalAmount(order.getTotalAmount());
		 
		 order1.setProductNames(order.getItems().stream().map(item -> item.getProduct().getName()).toList());
		 
		 
		 return order1;
		 
	 }
	 
	 
	 
	 
	 private PaymentDTO toPayment(Payment payment) {
		 
		 
		 PaymentDTO newPayment = new PaymentDTO();
		 
		 newPayment.setPaymentId(payment.getId());
		 
		 newPayment.setAmount(payment.getAmount());
		 
		 newPayment.setPaymentDate(payment.getPaymentDate());
		 
		 
		 newPayment.setStatus(payment.getStatus());
		 
		 return newPayment;
	 }
	
	
	

}
