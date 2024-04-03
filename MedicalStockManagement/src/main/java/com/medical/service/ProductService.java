package com.medical.service;

import java.util.List;

import com.medical.entity.Product;
import com.medical.exception.ProductException;
import com.medical.requestDTO.ProductRequestDto;
import com.medical.responseDTO.ProductResponseDto;

import com.medical.exception.StockException;



public interface ProductService {
	
	
	 
	  List<ProductResponseDto> getAllProducts() ;
	  ProductResponseDto updateProduct(Integer productId, ProductRequestDto productRequestDto) throws ProductException;
	  ProductResponseDto getProductById(Integer productId) throws ProductException;
	  String deleteProductById(Integer productId)throws ProductException;
	List<ProductResponseDto> createProduct(List<ProductRequestDto> productRequestDtos);
	  
	
	
	
	 
}