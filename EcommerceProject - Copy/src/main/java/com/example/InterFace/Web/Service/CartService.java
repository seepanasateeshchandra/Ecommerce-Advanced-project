package com.example.InterFace.Web.Service;

import com.example.InterFace.Web.RequestDTO.CartDto;

public interface CartService {
	
	CartDto getUserCart(Long userId);
	
	CartDto addItemToCart(Long userId,Long productId,int quantity);
	
	CartDto updateQuantity(Long userId,Long productId,int quantity);
	
	void removeItem(Long userId,Long productId);
	
	void clearCart(Long userId);
	
	

}
