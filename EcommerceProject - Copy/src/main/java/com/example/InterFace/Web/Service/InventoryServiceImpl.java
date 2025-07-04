package com.example.InterFace.Web.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.InterFace.Web.Entity.Inventory;
import com.example.InterFace.Web.Entity.Product;
import com.example.InterFace.Web.ExceptionHandler.ResourceNotFoundException;
import com.example.InterFace.Web.Repository.InventoryRepository;
import com.example.InterFace.Web.Repository.ProductRepository;
import com.example.InterFace.Web.RequestDTO.InventoryRequestDTO;
import com.example.InterFace.Web.ResponseDTO.InventoryResponseDTO;

@Service
public class InventoryServiceImpl implements InventoryService {
	
	@Autowired
	private InventoryRepository inventoryRepository;
	
	@Autowired
	private ProductRepository productRepository;

	
	 @Override
	    public boolean checkAvailability(Long productId, int requiredQty) {
	        Inventory inventory = inventoryRepository.findByProductId(productId)
	            .orElseThrow(() -> new RuntimeException("Inventory not found"));
	        return inventory.getQuantity() >= requiredQty;
	    }

	    @Override
	    public void reduceStock(Long productId, int quantity) {
	        Inventory inventory = inventoryRepository.findByProductId(productId)
	            .orElseThrow(() -> new RuntimeException("Inventory not found"));
	        if (inventory.getQuantity() < quantity) {
	            throw new RuntimeException("Insufficient stock for product: " + productId);
	        }
	        inventory.setQuantity(inventory.getQuantity() - quantity);
	        inventoryRepository.save(inventory);
	    }

	    @Override
	    public void increaseStock(Long productId, int quantity) {
	        Inventory inventory = inventoryRepository.findByProductId(productId)
	            .orElseThrow(() -> new RuntimeException("Inventory not found"));
	        inventory.setQuantity(inventory.getQuantity() + quantity);
	        inventoryRepository.save(inventory);
	    }

	    @Override
	    public InventoryResponseDTO getInventoryByProduct(Long productId) {
	        Inventory inventory = inventoryRepository.findByProductId(productId)
	            .orElseThrow(() -> new RuntimeException("Inventory not found"));
	        return new InventoryResponseDTO(inventory.getId(), inventory.getProduct().getName(),inventory.getQuantity(),inventory.getLastUpdated());
	    }
	

	
}
