package com.medical.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.medical.entity.Stock;
import com.medical.exception.StockException;
import com.medical.repository.StockRepository;
import com.medical.service.StockService;

@Service
public class StockServiceImpl implements StockService {
	
	private StockRepository stockRepository;

	@Override
	public Stock addStock(Stock stock) throws StockException {
		return stockRepository.save(stock);
	}

	@Override
	public Stock getStockById(Integer stockId) throws StockException {
		Optional<Stock> opt= stockRepository.findById(stockId);
		return  opt.get();
	}

	@Override
	public String deleteStockById(Integer stockId) throws StockException {
		Optional<Stock> opt= stockRepository.findById(stockId);
		Stock stock=  opt.get();
		stockRepository.delete(stock);
		return "deleted successfully";
	}

	@Override
	public Stock updateStockById(Integer stockId, Stock stock) {
		Optional<Stock> opt= stockRepository.findById(stockId);
		Stock existingStock=  opt.get();
		existingStock.setProducts(stock.getProducts());
		existingStock.setLastUpdated(stock.getLastUpdated());
		existingStock.setQuantityAvailable(stock.getQuantityAvailable());
		
		return stockRepository.save(existingStock);
	}

	@Override
	public List<Stock> getAllStock() {
		return stockRepository.findAll();
	}

	

}
