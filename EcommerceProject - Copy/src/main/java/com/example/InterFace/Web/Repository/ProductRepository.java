package com.example.InterFace.Web.Repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.InterFace.Web.Entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	Page<Product> findByCategoryIgnoreCase(String category, Pageable pageable);

	long countByStockQuantityLessThan(int quantity);
	
	
	


}
