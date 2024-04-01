package com.medical.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medical.dto.ProductDto;
import com.medical.entity.Product;
import com.medical.exception.ProductException;
import com.medical.requestDTO.ProductRequestDto;
import com.medical.responseDTO.ProductResponseDto;
import com.medical.service.ProductDtoService;
import com.medical.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductDtoService productDtoService;
     
	
	  @PostMapping("/addProduct")
	    public ResponseEntity<ProductResponseDto> createProduct(@RequestBody ProductRequestDto productRequestDto) {
	        ProductResponseDto productResponseDto = productDtoService.createProduct(productRequestDto);
	           return new ResponseEntity<>(productResponseDto,HttpStatus.OK);
	    }
             
	  @GetMapping("/get/{productId}")
	  public ResponseEntity<ProductResponseDto>getProductById(@PathVariable("productId")Integer productId) throws ProductException{
		  ProductResponseDto productResponseDto=productDtoService.getProductById(productId);
		  return new ResponseEntity<>(productResponseDto,HttpStatus.OK);
	  }
	  
	  @GetMapping("/getAll")
	  public ResponseEntity<List<ProductResponseDto>>getAllProducts(){
		  List<ProductResponseDto> list= productDtoService.getAllProducts();
		  return new ResponseEntity<>(list,HttpStatus.OK);
	  }
	  
	  @PutMapping("/updateProductDto")
	  public ResponseEntity<ProductResponseDto>updateProduct(@PathVariable("productId")Integer productId, @RequestBody ProductRequestDto productRequestDto) throws ProductException {
		 
		    ProductResponseDto updatedProduct = productDtoService.updateProduct(productId, productRequestDto);
		  
		return new ResponseEntity<>(updatedProduct,HttpStatus.OK);
		  
	  }
	  
	/*  private Product convertToEntity(ProductRequestDto requestDto) {
	        Product product = new Product();
	        product.setName(requestDto.getName());
	        product.setDescription(requestDto.getDescription());
	        product.setManufacturer(requestDto.getManufacturer());
	        product.setExpiryDate(requestDto.getExpiryDate());
	        product.setUnitPrice(requestDto.getUnitPrice());
	        product.setQuantityInStock(requestDto.getQuantityInStock());
	        product.setCategory(requestDto.getCategory());
	        product.setBatchNumber(requestDto.getBatchNumber());
	      //  product.setStockId(requestDto.getStockId());
	        product.setStockId(requestDto.getStockId());
	        return product;
	    }

	   private ProductResponseDto convertToResponseDto(Product product) {
	        ProductResponseDto dto = new ProductResponseDto();
	        dto.setProductId(product.getProductId());
	        dto.setName(product.getName());
	        dto.setQuantityInStock(product.getQuantityInStock());
	        dto.setUnitPrice(product.getUnitPrice());
	        dto.setExpiryDate(product.getExpiryDate());
	       
	        dto.setStockId(product.getStockId());
	        return dto;
	   
	}*/

      
      
}
      

