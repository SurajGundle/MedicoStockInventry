package com.medical.service;

import java.util.List;

import com.medical.entity.Product;
import com.medical.entity.Supplier;
import com.medical.exception.StockException;
import com.medical.exception.SupplierException;
import com.medical.requestDTO.StockRequestDTO;
import com.medical.requestDTO.SupplierRequestDto;
import com.medical.responseDTO.StockResponseDTO;
import com.medical.responseDTO.SupplierResponseDto;

public interface StockService {
	
	StockResponseDTO addStock(StockRequestDTO stockRequestDTO ) throws StockException;
	StockResponseDTO getStockById(Integer stockId) throws StockException;
	String deleteStockById(Integer stockId) throws StockException;
	StockResponseDTO updateStockById(Integer id,StockRequestDTO stockRequestDTO) throws StockException;
	List<StockResponseDTO> getAllStock();
	 List<Product> getProductsByStockId(Integer stockId) throws StockException;

}


