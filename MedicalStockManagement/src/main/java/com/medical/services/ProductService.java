package com.medical.services;

import java.util.List;

import com.medical.RESTFUL.dto.request.ProductRequestDto;
import com.medical.RESTFUL.dto.response.ProductResponseDto;
import com.medical.RESTFUL.error.handler.ProductException;
import com.medical.entities.Product;

public interface ProductService {

	List<ProductResponseDto> getAllProducts();

	ProductResponseDto updateProduct(Integer productId, ProductRequestDto productRequestDto) throws ProductException;

	ProductResponseDto getProductById(Integer productId) throws ProductException;

	String deleteProductById(Integer productId) throws ProductException;

	Product addNewProduct(Product product);

}