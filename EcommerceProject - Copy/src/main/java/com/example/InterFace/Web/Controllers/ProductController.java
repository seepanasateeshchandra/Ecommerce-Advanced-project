package com.example.InterFace.Web.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.InterFace.Web.RequestDTO.ProductDto;
import com.example.InterFace.Web.Service.ProductServiceImplementation;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
	ProductServiceImplementation productImpl;
	
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/create")
	public ResponseEntity<ProductDto> create(@RequestBody ProductDto dto){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(productImpl.createProduct(dto));
		
		
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/update/{id}")
	public ResponseEntity<ProductDto> update(@PathVariable Long id,@RequestBody ProductDto dto){
		
		
		return ResponseEntity.status(HttpStatus.OK).body(productImpl.updateProduct(id, dto));
		
	}
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		
		
		if(productImpl.deleteProduct(id).equalsIgnoreCase("product deleted")) {
			
		     return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(productImpl.deleteProduct(id));
		     
		}else {
			
			return ResponseEntity.status(HttpStatusCode.valueOf(204)).body(productImpl.deleteProduct(id));
		}
		
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<ProductDto> getById(@PathVariable Long id){
		
		
		return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(productImpl.getProductById(id));
		
		
	}
	
	
	
	@GetMapping("/getAll")
	public ResponseEntity<Page<ProductDto>> getAll(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "10") int size){
		
		
		return ResponseEntity.ok(productImpl.getAllProducts(page, size));
		
		
		
	}
	
	@GetMapping("/category")
	public ResponseEntity<Page<ProductDto>> getByCategory(@RequestParam String category,@RequestParam(defaultValue = "0")int page,@RequestParam(defaultValue = "0") int size){
		
		return ResponseEntity.ok(productImpl.getByCategory(category, page, size));
		
		
		
	}
	
	
	

}
