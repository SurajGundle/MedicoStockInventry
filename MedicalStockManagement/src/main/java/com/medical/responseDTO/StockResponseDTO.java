package com.medical.responseDTO;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class StockResponseDTO {
	
	private Integer stockId;
	private Integer quantityAvailable;
	private LocalDateTime lastUpdated;
	
	


}
