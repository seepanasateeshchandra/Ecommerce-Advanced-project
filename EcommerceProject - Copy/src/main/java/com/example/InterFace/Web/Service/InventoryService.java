package com.example.InterFace.Web.Service;

import java.util.List;

import com.example.InterFace.Web.RequestDTO.InventoryRequestDTO;
import com.example.InterFace.Web.ResponseDTO.InventoryResponseDTO;

public interface InventoryService {
	
	    boolean checkAvailability(Long productId, int requiredQty);
	    void reduceStock(Long productId, int quantity);
	    void increaseStock(Long productId, int quantity);
	    InventoryResponseDTO getInventoryByProduct(Long productId);

}
