package com.example.InterFace.Web.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.InterFace.Web.RequestDTO.CartDto;
import com.example.InterFace.Web.Service.CartService;
import com.example.InterFace.Web.Service.CartServiceImpl;

@RestController
@RequestMapping("/api/cart")
public class CartController {
	
	@Autowired
	private  CartServiceImpl cartService;
	
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/byUserId/{userId}")
	public ResponseEntity<CartDto> getCart(@PathVariable Long userId){
		
		
		return ResponseEntity.ok(cartService.getUserCart(userId));
		
		
	}
	
	@PreAuthorize("hasRole('USER')")
	@PostMapping("/add")
	public ResponseEntity<CartDto> addItem(@RequestParam Long userId,@RequestParam Long productId,@RequestParam int quantity){
		
		
		return ResponseEntity.ok(cartService.addItemToCart(userId, productId, quantity));
		
		
	}
	
	@PreAuthorize("hasRole('USER')")
	@PutMapping("/update")
	public ResponseEntity<CartDto> updateQty(@RequestParam Long userId,@RequestParam Long productId,@RequestParam int quantity){
		
		return ResponseEntity.ok(cartService.updateQuantity(userId, productId, quantity));
		
		
	}
	
	@PreAuthorize("hasRole('USER')")
	@DeleteMapping("/clear/{userId}")
	public ResponseEntity<?> clearCart(@PathVariable Long userId){
		
		
		cartService.clearCart(userId);
		
		return ResponseEntity.noContent().build();
		
		
	}
	
	
	@PreAuthorize("hasRole('USER')")
	@DeleteMapping("/remove")
	public ResponseEntity<?> removeItem(@RequestParam Long userId,@RequestParam Long productId){
		cartService.removeItem(userId, productId);
		
		return ResponseEntity.noContent().build();
	}
	
	
	
	
	

}
