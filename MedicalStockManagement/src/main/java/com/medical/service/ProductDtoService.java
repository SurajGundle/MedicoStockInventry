package com.medical.service;

import java.util.List;

import com.medical.exception.ProductException;
import com.medical.requestDTO.ProductRequestDto;
import com.medical.responseDTO.ProductResponseDto;

public interface ProductDtoService {
	 ProductResponseDto createProduct(ProductRequestDto producteRequestDto);
	  List<ProductResponseDto> getAllProducts() ;
	  ProductResponseDto updateProduct(Integer productId, ProductRequestDto productRequestDto) throws ProductException;
	  ProductResponseDto getProductById(Integer productId) throws ProductException;

}
