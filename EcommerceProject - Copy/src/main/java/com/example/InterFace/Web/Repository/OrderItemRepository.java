package com.example.InterFace.Web.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.InterFace.Web.Entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
	
}
