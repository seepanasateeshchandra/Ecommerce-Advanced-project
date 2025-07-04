package com.example.InterFace.Web.Service;

import org.springframework.data.domain.Page;
import com.example.InterFace.Web.RequestDTO.ProductDto;
public interface ProductInterface {
	
	
	ProductDto createProduct(ProductDto dto);
	
	
	ProductDto updateProduct(Long id,ProductDto dto);
	
	String deleteProduct(long id);
	
	ProductDto getProductById(long id);
	
	Page<ProductDto> getAllProducts(int page,int size);
	
	Page<ProductDto> getByCategory(String category,int page,int size);
	
	
}
	
	