package com.example.InterFace.Web.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.InterFace.Web.Entity.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
	
	
	void deleteByCartIdAndProductId(Long cartId,Long productId);

}
