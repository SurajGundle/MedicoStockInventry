package com.medical.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.medical.exception.ProductException;
import com.medical.requestDTO.ProductRequestDto;
import com.medical.responseDTO.ProductResponseDto;

import com.medical.service.ProductService;


@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService productService;
     
	
	
	 /*   public ResponseEntity<ProductResponseDto> createProduct(@RequestBody ProductRequestDto productRequestDto) {
	        ProductResponseDto productResponseDto = productDtoService.createProduct(productRequestDto);
	           return new ResponseEntity<>(productResponseDto,HttpStatus.OK);
	    }*/
	   
 
	  @PostMapping("/addProduct")
	    public ResponseEntity<List<ProductResponseDto>> addProducts(@RequestBody List<ProductRequestDto> productRequestDtos) {
	        List<ProductResponseDto> addProduct = productService.createProduct(productRequestDtos);
	        return new ResponseEntity<>(addProduct, HttpStatus.OK);
	    }

             
	  @GetMapping("/getProduct/{productId}")
	  public ResponseEntity<ProductResponseDto>getProductById(@PathVariable("productId")Integer productId) throws ProductException{
		  ProductResponseDto productResponseDto=productService.getProductById(productId);
		  return new ResponseEntity<>(productResponseDto,HttpStatus.OK);
	  }
	  
	  @GetMapping("/getAllProducts")
	  public ResponseEntity<List<ProductResponseDto>>getAllProducts(){
		  List<ProductResponseDto> list= productService.getAllProducts();
		  return new ResponseEntity<>(list,HttpStatus.OK);
	  }
	  
	  @PutMapping("/updateProduct/{productId}")
	  public ResponseEntity<ProductResponseDto>updateProduct(@PathVariable("productId")Integer productId, @RequestBody ProductRequestDto productRequestDto) throws ProductException {
		 
		    ProductResponseDto updatedProduct = productService.updateProduct(productId, productRequestDto);
		  
		return new ResponseEntity<>(updatedProduct,HttpStatus.OK);
		  
	  }
	  

   @DeleteMapping("/deleteProduct/{productId}")
   
	public ResponseEntity<String> deleteProductById(@PathVariable("productId") Integer productId) throws ProductException {
		return new ResponseEntity<>(productService.deleteProductById(productId),HttpStatus.OK);
	}
   }

      

