package com.medical.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.medical.entity.Product;
import com.medical.exception.ProductException;
import com.medical.repository.ProductRepository;
import com.medical.requestDTO.ProductRequestDto;
import com.medical.responseDTO.ProductResponseDto;

import com.medical.service.ProductDtoService;

@Service
public class ProductDtoServiceImpl implements ProductDtoService {
	
	@Autowired
	 private ProductRepository productRepository;

	@Autowired

	private ModelMapper modelMapper;


	@Override
	public ProductResponseDto createProduct(ProductRequestDto productRequestDto) {
		Product product = modelMapper.map(productRequestDto, Product.class);
        productRepository.save(product);
        return modelMapper.map(product, ProductResponseDto.class);
    
}

	@Override
	public List<ProductResponseDto> getAllProducts() {
	    List<Product> products = productRepository.findAll();
	    List<ProductResponseDto> productResponseDtos = new ArrayList<>();
	    for (Product product : products) {
	        productResponseDtos.add(modelMapper.map(product, ProductResponseDto.class));
	    }
	    return productResponseDtos;
	}



	public ProductResponseDto getProductById(Integer productId)  throws ProductException{
		Product product=productRepository.findById(productId).get();
		ProductResponseDto productResponseDto=modelMapper.map(product, ProductResponseDto.class);
		return productResponseDto;
	}

	@Override
	public ProductResponseDto updateProduct(Integer productId, ProductRequestDto productRequestDto) throws ProductException {
	    Optional<Product> opt = productRepository.findById(productId);
	    if (opt.isEmpty()) {
	        throw new ProductException("Product with ID " + productId + " not found");
	    }

	    Product existingProduct = opt.get();
	    existingProduct.setName(productRequestDto.getName());

	    existingProduct.setUnitPrice(productRequestDto.getUnitPrice());
	    existingProduct.setExpiryDate(productRequestDto.getExpiryDate());
	    existingProduct.setQuantityInStock(productRequestDto.getQuantityInStock());

	    productRepository.save(existingProduct);
	    
	    return modelMapper.map(existingProduct, ProductResponseDto.class);
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


	}

	


	
	

