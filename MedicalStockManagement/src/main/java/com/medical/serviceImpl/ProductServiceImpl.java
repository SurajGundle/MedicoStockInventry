package com.medical.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medical.dto.ProductDto;
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
private ModelMapper modelMappper;

	@Override
	public Product getProductById(Integer productId) throws ProductException {
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
			 existProduct.setBatchNumber(updateProduct.getBatchNumber());
			 existProduct.setCategory(updateProduct.getCategory());
			 existProduct.setDescription(updateProduct.getDescription());
			 existProduct.setExpiryDate(updateProduct.getExpiryDate());
			 existProduct.setManufacturer(updateProduct.getManufacturer());
			 existProduct.setQuantityInStock(updateProduct.getQuantityInStock());
			 existProduct.setUnitPrice(updateProduct.getUnitPrice());
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
	public String deleteUserById(Integer productId) throws ProductException{
		// TODO Auto-generated method stub
		Optional<Product> opt=productRepository.findById(productId);
		if(opt.isEmpty()) {
			throw new ProductException(productId+"Product is not available for delete");
			
		}
	     	productRepository.deleteById(productId);
		return "product with productId"+productId+" delete successfully";
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


}



	    
	
	    
	

	


	

		
