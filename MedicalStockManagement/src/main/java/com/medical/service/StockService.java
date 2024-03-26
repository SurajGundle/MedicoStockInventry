package com.medical.service;

import java.util.List;

import com.medical.entity.Stock;
import com.medical.exception.StockException;

public interface StockService {
	
	Stock addStock(Stock stock ) throws StockException;
	Stock getStockById(Integer stockId) throws StockException;
	String deleteStockById(Integer stockId) throws StockException;
	Stock updateStockById(Integer id,Stock stock);
	List<Stock> getAllStock();

}
