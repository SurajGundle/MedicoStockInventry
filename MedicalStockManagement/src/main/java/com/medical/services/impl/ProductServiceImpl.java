package com.medical.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medical.RESTFUL.dto.request.ProductRequestDto;
import com.medical.RESTFUL.dto.response.ProductResponseDto;
import com.medical.RESTFUL.error.handler.ProductException;
import com.medical.entities.Product;
import com.medical.services.ProductService;
import com.medical.services.dao.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	
@Autowired
ModelMapper modelMapper;
@Override
public List<ProductResponseDto> getAllProducts() {
	// TODO Auto-generated method stub
	   List<Product> products = productRepository.findAll();
	    List<ProductResponseDto> productResponseDtos = new ArrayList<>();
	    for (Product product : products) {
	        productResponseDtos.add(modelMapper.map(product, ProductResponseDto.class));
	    }
	    return productResponseDtos;
	}

@Override
public ProductResponseDto updateProduct(Integer productId, ProductRequestDto productRequestDto) throws ProductException {
	// TODO Auto-generated method stub
    Optional<Product> opt = productRepository.findById(productId);
    if (opt.isEmpty()) {
        throw new ProductException("Product with ID " + productId + " not found");
    }

    Product existingProduct = opt.get();
    existingProduct.setName(productRequestDto.getName());

    existingProduct.setUnitPrice(productRequestDto.getUnitPrice());
  
    existingProduct.setQuantityInStock(productRequestDto.getQuantityInStock());

    productRepository.save(existingProduct);
    
    return modelMapper.map(existingProduct, ProductResponseDto.class);
}


@Override
public ProductResponseDto getProductById(Integer productId) throws ProductException {
	// TODO Auto-generated method stub
      Product product=productRepository.findById(productId).get();
		ProductResponseDto productResponseDto=modelMapper.map(product, ProductResponseDto.class);
		return productResponseDto;
	}
	

@Override
public String deleteProductById(Integer productId) throws ProductException {
	// TODO Auto-generated method stub
	 Optional<Product> opt = productRepository.findById(productId);
	    if (opt.isEmpty()) {
	        throw new ProductException("Product with ID " + productId + " not available");
	    }
	   	productRepository.deleteById(productId);
		return "product with productId"+productId+" delete successfully";
	

}

@Override
public List<ProductResponseDto> createProduct(List<ProductRequestDto> productRequestDto) {
	// TODO Auto-generated method stub
	  List<ProductResponseDto> productResponseDto = new ArrayList<>();
    for (ProductRequestDto productRequest : productRequestDto) {
        Product product = modelMapper.map(productRequest, Product.class); 
          
          productRepository.save(product);
          productResponseDto.add(modelMapper.map(product, ProductResponseDto.class));
    }
    return productResponseDto;
}

}



