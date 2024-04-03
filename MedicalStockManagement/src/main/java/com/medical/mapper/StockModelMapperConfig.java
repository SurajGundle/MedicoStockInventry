package com.medical.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;

import com.medical.entity.Stock;
import com.medical.requestDTO.StockRequestDTO;
import com.medical.responseDTO.StockResponseDTO;

@Configuration
public class StockModelMapperConfig {

	
	   public ModelMapper modelMapper() {
	        ModelMapper modelMapper = new ModelMapper();
	        // Mapping from StockRequestDTO to Stock
	        modelMapper.createTypeMap(StockRequestDTO.class, Stock.class)
	                .addMapping(StockRequestDTO::getQuantityAvailable, Stock::setQuantityAvailable)
	                .addMapping(StockRequestDTO::getLastUpdated, Stock::setLastUpdated);
	             // .addMapping(StockRequestDTO::getSupplierId,Stock::setSupplierId);
	        
	                
	        
	        //Mapping from stock to StockResponseDTO
	        modelMapper.createTypeMap(Stock.class, StockResponseDTO.class)
	        .addMapping(Stock::getStockId, StockResponseDTO::setStockId)
	        .addMapping(Stock::getQuantityAvailable, StockResponseDTO::setQuantityAvailable)
	        .addMapping(Stock::getLastUpdated, StockResponseDTO::setLastUpdated);
	      //  .addMapping(Stock::getSupplierId,StockResponseDTO::setSupplierId);
	        
	        
	         
			return modelMapper;
	   }
}
