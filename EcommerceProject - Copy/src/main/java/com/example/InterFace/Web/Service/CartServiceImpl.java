package com.example.InterFace.Web.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.InterFace.Web.Entity.Cart;
import com.example.InterFace.Web.Entity.CartItem;
import com.example.InterFace.Web.Entity.Product;
import com.example.InterFace.Web.ExceptionHandler.ResourceNotFoundException;
import com.example.InterFace.Web.Repository.CartRepository;
import com.example.InterFace.Web.Repository.ProductRepository;
import com.example.InterFace.Web.Repository.UserRepository;
import com.example.InterFace.Web.RequestDTO.CartDto;

import java.util.*;

import com.example.InterFace.Web.RequestDTO.*;
import com.*;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartRepository cartRepo;
	
	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public CartDto getUserCart(Long userId) {
		// TODO Auto-generated method stub
		
		Cart cart = cartRepo.findByUserId(userId).orElseGet(()-> createNewCart(userId));
		return toDTo(cart);
		
		
	}

	@Override
	public CartDto addItemToCart(Long userId, Long productId, int quantity) {
		// TODO Auto-generated method stub
		
		
		Cart cart = cartRepo.findByUserId(userId).orElseGet(()->createNewCart(userId));
		
		Product product = productRepo.findById(productId).orElseThrow(()-> new ResourceNotFoundException("Product is Not Found") );
		
		
		Optional<CartItem> existingItem = cart.getItems().stream().filter(item -> item.getProduct().getId().equals(productId)).findFirst();
		
		
		if(existingItem.isPresent()) {
			
			existingItem.get().setQuantity(existingItem.get().getQuantity() + quantity);
		}else {
            CartItem newItem = new CartItem();
            newItem.setCart(cart);
            newItem.setProduct(product);
            newItem.setQuantity(quantity);
            cart.getItems().add(newItem);
        }
		
		cartRepo.save(cart);
        return toDTo(cart);
	}

	@Override
	public CartDto updateQuantity(Long userId, Long productId, int quantity) {
		// TODO Auto-generated method stub
		Cart cart = cartRepo.findByUserId(userId).orElseThrow();
		
		
		 cart.getItems().forEach(item -> {
	            if (item.getProduct().getId().equals(productId)) {
	                item.setQuantity(item.getQuantity() + quantity);
	            }
	        });
		 
		 cartRepo.save(cart);
		 
		 return toDTo(cart);
		
		
	}

	@Override
	public void removeItem(Long userId, Long productId) {
		Cart cart = cartRepo.findByUserId(userId).orElseThrow();
        cart.getItems().removeIf(item -> item.getProduct().getId().equals(productId));
        cartRepo.save(cart);
		
	}

	@Override
	public void clearCart(Long userId) {
		// TODO Auto-generated method stub
		
		Cart cart = cartRepo.findByUserId(userId).orElseThrow();
		
		cart.getItems().clear();
		
		cartRepo.save(cart);
		
		
		
	}
	
	
	private CartDto toDTo(Cart cart) {
		
		
		List<CartItemsDto>  items = new ArrayList<>();
		
		for(CartItem item :  cart.getItems()) {
			
			Product p = item.getProduct();
			
			items.add(new CartItemsDto(p.getId(),p.getName(),p.getPrice(),item.getQuantity()));
			
			
		}
		
		return new CartDto(cart.getUser().getId(),items);
		
		
		
		
		
	}
	
	
	private Cart createNewCart(Long userId) {
		
		
		Cart cart = new Cart();
		
		cart.setUser(userRepo.findById(userId).orElseThrow());
		cart.setItems(new ArrayList<>());
		
		
		return cartRepo.save(cart);
	}

}
