package com.medical.requestDTO;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;




@Data
public class StockRequestDTO {
	
	
	private Integer quantityAvailable;
	private LocalDateTime lastUpdated;
	
	

}
