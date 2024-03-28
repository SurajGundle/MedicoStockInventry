package com.medical.responseDTO;

import java.time.LocalDateTime;
import java.util.List;

import com.medical.entity.Product;

import lombok.Data;

@Data
public class StockResponseDTO {
	
	private Integer stockId;
	private Integer quantityAvailable;
	private LocalDateTime lastUpdated;
	private List<Product> products;
	
	


}
