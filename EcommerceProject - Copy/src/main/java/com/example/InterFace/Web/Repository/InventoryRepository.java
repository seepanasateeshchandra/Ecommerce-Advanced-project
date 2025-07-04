package com.example.InterFace.Web.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.InterFace.Web.Entity.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
	
	Optional<Inventory> findByProductId(Long productId);

	void deleteByProductId(Long id);
	
	

}
