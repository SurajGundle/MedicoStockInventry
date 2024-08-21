package com.medical.RESTFUL.resources.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medical.RESTFUL.dto.request.ProductRequestDto;
import com.medical.RESTFUL.dto.response.ProductResponseDto;
import com.medical.RESTFUL.resources.ProductResource;
import com.medical.RESTFUL.resources.response.handler.Response;
import com.medical.RESTFUL.resources.response.handler.ResponseBuilder;
import com.medical.RESTFUL.response.enums.StatusEnum;
import com.medical.RESTFUL.response.enums.SuccessCode;
import com.medical.entities.Product;
import com.medical.services.ProductService;

@RestController
@RequestMapping(value = ProductResource.RESOURCE_PATH)
public class ProductResourceImpl implements ProductResource {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	ModelMapper modelMapper;
	

	@Override
	public ResponseEntity<Response> addNewProduct(ProductRequestDto productRequestDto) {
		
		Product product = modelMapper.map(productRequestDto, Product.class); 
		
		Product addedProduct= productService.addNewProduct(product);
		
		ProductResponseDto productResponseDto=modelMapper.map(addedProduct, ProductResponseDto.class);

		return ResponseEntity.status(HttpStatus.OK)
				.body(ResponseBuilder.builder().status(StatusEnum.SUCCESS.getValue(),SuccessCode.OK.getCode(),
						"Product "+productResponseDto+" addedd Succcessfully").build());
	}

}
