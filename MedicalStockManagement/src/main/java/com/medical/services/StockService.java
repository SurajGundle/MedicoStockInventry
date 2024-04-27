package com.medical.services;

import java.util.List;

import com.medical.RESTFUL.dto.request.StockRequestDTO;
import com.medical.RESTFUL.dto.response.StockResponseDTO;
import com.medical.RESTFUL.error.handler.StockException;
import com.medical.entities.Product;

public interface StockService {

	StockResponseDTO addStock(StockRequestDTO stockRequestDTO) throws StockException;

	StockResponseDTO getStockById(Integer stockId) throws StockException;

	String deleteStockById(Integer stockId) throws StockException;

	StockResponseDTO updateStockById(Integer id, StockRequestDTO stockRequestDTO) throws StockException;

	List<StockResponseDTO> getAllStock();

	List<Product> getProductsByStockId(Integer stockId) throws StockException;

}
