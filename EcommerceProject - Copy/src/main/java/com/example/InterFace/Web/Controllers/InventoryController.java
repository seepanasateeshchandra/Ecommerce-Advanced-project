package com.example.InterFace.Web.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.InterFace.Web.RequestDTO.InventoryRequestDTO;
import com.example.InterFace.Web.ResponseDTO.InventoryResponseDTO;
import com.example.InterFace.Web.Service.InventoryServiceImpl;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RequestMapping("/api/inventory")
@RestController
public class InventoryController {
	
	@Autowired
	private InventoryServiceImpl inventoryService;
	
	    

	    @GetMapping("/product/{productId}")
	    public ResponseEntity<InventoryResponseDTO> getInventory(@PathVariable Long productId) {
	        return ResponseEntity.ok(inventoryService.getInventoryByProduct(productId));
	    }

	   
	

}
