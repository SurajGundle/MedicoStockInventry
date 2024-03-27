package com.medical.service;

import java.util.List;

import com.medical.entity.Stock;
import com.medical.exception.StockException;
import com.medical.requestDTO.StockRequestDTO;
import com.medical.responseDTO.StockResponseDTO;

public interface StockService {
	
	StockResponseDTO addStock(StockRequestDTO stockRequestDTO ) throws StockException;
	StockResponseDTO getStockById(Integer stockId) throws StockException;
	String deleteStockById(Integer stockId) throws StockException;
	StockResponseDTO updateStockById(Integer id,StockRequestDTO stockRequestDTO) throws StockException;
	List<StockResponseDTO> getAllStock();

}
