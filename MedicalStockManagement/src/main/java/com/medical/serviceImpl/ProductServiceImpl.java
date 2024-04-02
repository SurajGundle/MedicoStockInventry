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
import com.medical.service.ProductService;

@Service
public class ProductServiceImpl  implements ProductService{
	
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
    existingProduct.setExpiryDate(productRequestDto.getExpiryDate());
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
          product.setProductId(productRequest.getProductId()); 
          productRepository.save(product);
          productResponseDto.add(modelMapper.map(product, ProductResponseDto.class));
    }
    return productResponseDto;
}

}


/*	public Product getProductById(Integer productId) throws ProductException {
		// TODO Auto-generated method stub
		Optional<Product>opt=productRepository.findById(productId);
		if(opt.isEmpty()) {
			throw new ProductException(productId+ " productId is already present");
		}
		return opt.get();
	}


	@Override
	public Product UpdateProductById(Integer productId, Product updateProduct) throws ProductException {
		// TODO Auto-generated method stub
		 Optional<Product> opt = productRepository.findById(productId);
		 if(opt.isEmpty()) {
			 throw new ProductException(productId +"is not present for Update");
		 }
			 Product existProduct=opt.get();
			 existProduct.setName(updateProduct.getName());
			 existProduct.setExpiryDate(updateProduct.getExpiryDate());
			 existProduct.setQuantityInStock(updateProduct.getQuantityInStock());
			 return productRepository.save(existProduct);
				
			  }
		
	
	
	
	@Override
	public Product addProduct(Product product) throws ProductException{
		// TODO Auto-generated method stub
	
		    if (productRepository.findById(product.getProductId()) != null) {
		        throw new ProductException("Product already present with this " + product.getProductId());
		    }
		    Product saveProduct = productRepository.save(product);
		    return saveProduct;
		}


  
	@Override
	public String deleteProductById(Integer productId) throws ProductException{
		// TODO Auto-generated method stub
		Optional<Product> opt=productRepository.findById(productId);
		if(opt.isEmpty()) {
			throw new ProductException(productId+"Product is not available for delete");
			
		}
	     	productRepository.deleteById(productId);
		return "product with productId : "+" : "+ productId+" delete successfully";
	}

	
	@Override
   	public List<Product> getAllProduct() throws ProductException {
		// TODO Auto-generated method stub
		List<Product> list=productRepository.findAll();
		if(list.size()==0) {
			throw new ProductException("No Product Available");
		}
		return list;
	}


}*/



	    
	
	    
	

	


	

		
