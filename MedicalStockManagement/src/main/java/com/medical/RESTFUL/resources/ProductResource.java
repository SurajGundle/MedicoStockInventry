package com.medical.RESTFUL.resources;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.medical.RESTFUL.dto.request.ProductRequestDto;
import com.medical.RESTFUL.resources.response.handler.Response;
import com.medical.entities.Product;

public interface ProductResource {
	
	public static final String RESOURCE_PATH = "/product";
	
	public static final String ADD_PRODUCT = "/addProduct";
//	public static final String GET_PRODUCT_BY_ID = "/getProduct/{productId}";
//	public static final String GET_ALL_PRODUCTS = "/getAllProducts";
//	public static final String UPDATE_PRODUCT_BY_ID = "/updateProduct/{productId}";
//	public static final String DELETE_PRODUCT_BY_ID = "/deleteProduct/{productId}";
//	
	
	@PostMapping(path = ADD_PRODUCT,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> addNewProduct(@RequestBody ProductRequestDto productRequestDto);


}
