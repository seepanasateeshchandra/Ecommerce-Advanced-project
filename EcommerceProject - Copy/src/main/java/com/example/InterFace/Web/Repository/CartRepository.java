package com.example.InterFace.Web.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.InterFace.Web.Entity.*;

public interface CartRepository extends JpaRepository<Cart, Long> {
	
	Optional<Cart> findByUserId(Long userId);
	
	Optional<Cart> findByUser(UserDetails user);

}
