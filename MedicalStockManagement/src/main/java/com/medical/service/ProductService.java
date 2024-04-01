package com.medical.service;

import java.util.List;

import com.medical.dto.ProductDto;
import com.medical.entity.Product;
import com.medical.exception.ProductException;
import com.medical.requestDTO.ProductRequestDto;
import com.medical.responseDTO.ProductResponseDto;

public interface ProductService {
	Product getProductById(Integer productId) throws ProductException;
	Product UpdateProductById(Integer productId, Product product)throws ProductException;

	Product addProduct(Product product) throws ProductException; 
	String deleteProductById(Integer productId)throws ProductException;
	List<Product> getAllProduct() throws ProductException; 
	
	
	
	
	 
}