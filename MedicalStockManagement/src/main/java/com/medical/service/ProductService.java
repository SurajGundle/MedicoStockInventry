package com.medical.service;

import java.util.List;

import com.medical.Exception.ProductException;
import com.medical.entity.Product;

public interface ProductService {
	Product getProductById(Integer productId) throws ProductException;
	Product UpdateProductById(Integer productId, Product product)throws ProductException;

	Product addProduct(Product product) throws ProductException; 
	String deleteUserById(Integer productId)throws ProductException;
	List<Product> getAllProduct() throws ProductException; 
	

}
