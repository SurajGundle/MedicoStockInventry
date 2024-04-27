package com.medical.services;

import java.util.List;

import com.medical.RESTFUL.dto.request.ProductRequestDto;
import com.medical.RESTFUL.dto.response.ProductResponseDto;
import com.medical.RESTFUL.error.handler.ProductException;

public interface ProductService {

	List<ProductResponseDto> getAllProducts();

	ProductResponseDto updateProduct(Integer productId, ProductRequestDto productRequestDto) throws ProductException;

	ProductResponseDto getProductById(Integer productId) throws ProductException;

	String deleteProductById(Integer productId) throws ProductException;

	List<ProductResponseDto> createProduct(List<ProductRequestDto> productRequestDtos);

}