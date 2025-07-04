package com.example.InterFace.Web.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.InterFace.Web.Entity.Order;
import com.example.InterFace.Web.Entity.UserDetails;

public interface OrderRepository extends JpaRepository<Order, Long> {
	
	List<Order> findByUserId(Long userId);

	List<Order> findTop5ByUserOrderByOrderDateDesc(UserDetails user);
	
	
	
	
	

}
