package com.medical.serviceImpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.medical.entity.Product;
import com.medical.exception.ProductException;
import com.medical.exception.StockException;
import com.medical.repository.ProductRepository;
import com.medical.repository.StockRepository;
import com.medical.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private StockRepository stockRepository;

	@Override
	public Product getProductById(Integer productId) throws ProductException {
		// TODO Auto-generated method stub
		Optional<Product> opt = productRepository.findById(productId);
		if (opt.isEmpty()) {
			throw new ProductException(productId + " productId is already present");
		}
		return opt.get();
	}

	@Override
	public Product UpdateProductById(Integer productId, Product updateProduct) throws ProductException {
		// TODO Auto-generated method stub
		Optional<Product> opt = productRepository.findById(productId);
		if (opt.isEmpty()) {
			throw new ProductException(productId + "is not present for Update");
		}
		Product existProduct = opt.get();
		existProduct.setName(updateProduct.getName());
		existProduct.setExpiryDate(updateProduct.getExpiryDate());
		existProduct.setQuantityInStock(updateProduct.getQuantityInStock());
		return productRepository.save(existProduct);

	}

	@Override
	public Product addProduct(Product product) throws ProductException, StockException {
		// TODO Auto-generated method stub

		if(stockRepository.findById(product.getStockId())!=null) {
			throw new StockException("Can't persist product, stock with id : "+product.getStockId()+" is not present");
		}
		Product saveProduct = productRepository.save(product);
		return saveProduct;
	}

	@Override
	public String deleteProductById(Integer productId) throws ProductException {
		// TODO Auto-generated method stub
		Optional<Product> opt = productRepository.findById(productId);
		if (opt.isEmpty()) {
			throw new ProductException(productId + "Product is not available for delete");

		}
		productRepository.deleteById(productId);
		return "product with productId : " + " : " + productId + " delete successfully";
	}

	@Override
	public List<Product> getAllProduct() throws ProductException {
		// TODO Auto-generated method stub
		List<Product> list = productRepository.findAll();
		if (list.size() == 0) {
			throw new ProductException("No Product Available");
		}
		return list;
	}

}
