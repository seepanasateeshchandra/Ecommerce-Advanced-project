package com.example.InterFace.Web.Service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
 

import com.example.InterFace.Web.Entity.Product;
import com.example.InterFace.Web.ExceptionHandler.ResourceNotFoundException;
import com.example.InterFace.Web.Repository.InventoryRepository;
import com.example.InterFace.Web.Repository.ProductRepository;
import com.example.InterFace.Web.RequestDTO.ProductDto;
import org.springframework.data.domain.Pageable;
import com.example.InterFace.Web.Entity.*;

@Service
public class ProductServiceImplementation implements ProductInterface {
	
	 @Autowired
	 private ProductRepository productRepository;
	 
	 @Autowired
	 private InventoryRepository inventoryRepository;
	 
	 
	 private ProductDto toDto(Product product) {
		 
		 
		 
		 return new ProductDto(
				 
				 product.getId(),
				 product.getName(),
				 product.getPrice(),
				 product.getStockQuantity(),
				 product.getCategory(),
				 product.getDescription()
				 
				 
				 
				 );
		 
	 }
	 
	 
	 private Product toEntity(ProductDto dto) {
		 
		 Product product = new Product();
		 
		 product.setId(dto.getId());
		 
		 product.setName(dto.getName());
		 
		 product.setDescription(dto.getDescription());
		 
		 product.setPrice(dto.getPrice());
		 
		 product.setCategory(dto.getCategory());
		 
		 product.setStockQuantity(dto.getStockQuantity());
		 
		 
		 createInventory(dto, product);
		 
		 
		 return product;
		 
		 
	 }
	 
	 
	 
	 private void createInventory(ProductDto dto,Product product) {
		 
		Inventory isExisting = inventoryRepository.findByProductId(product.getId()).get();
		
		if(isExisting != null) {
			
			isExisting.setQuantity(isExisting.getQuantity()+dto.getStockQuantity());
			inventoryRepository.save(isExisting);
		}else {
		 
		 Inventory inventory  = new Inventory();
		
		 inventory.setLastUpdated(LocalDateTime.now());
		 inventory.setProduct(product);
		 inventory.setQuantity(dto.getStockQuantity());
		
		 inventoryRepository.save(inventory);
		}
		 
		 
	 }
	 
	 
	 private void deleteInventory(Product product) {
		 
		 
	  inventoryRepository.deleteByProductId(product.getId());	 
		 
		 
		 
	 }

	@Override
	public ProductDto createProduct(ProductDto dto) {
		// TODO Auto-generated method stub
		
		
		
		return toDto(productRepository.save(toEntity(dto)));
		
		
	}

	@Override
	public ProductDto updateProduct(Long id, ProductDto dto) {
		// TODO Auto-generated method stub
		
		
		Product existing = productRepository.findById(id).orElseThrow();
		
		existing.setName(dto.getName());
		
		existing.setDescription(dto.getDescription());
		existing.setCategory(dto.getCategory());
		existing.setPrice(dto.getPrice());
		existing.setStockQuantity(dto.getStockQuantity());
		
		
		
		return toDto(productRepository.save(existing));
	}

	@Override
	public String deleteProduct(long id) {
		// TODO Auto-generated method stub
		
		Product product = productRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("product is not found"));
		
		deleteInventory(product);
		
		productRepository.deleteById(id);
		
		
		return "product is deleted";
		
		
		
		
		
	}

	@Override
	public ProductDto getProductById(long id) {
		// TODO Auto-generated method stub
		return toDto(productRepository.findById(id).orElseThrow());
	}

	@Override
	public Page<ProductDto> getAllProducts(int page, int size) {
		// TODO Auto-generated method stub
		
		Pageable pageable = PageRequest.of(page, size);
		
		return productRepository.findAll(pageable).map(this::toDto);
	}

	@Override
	public Page<ProductDto> getByCategory(String category, int page, int size) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(page, size);
        return productRepository.findByCategoryIgnoreCase(category, pageable).map(this::toDto);
	}

}
