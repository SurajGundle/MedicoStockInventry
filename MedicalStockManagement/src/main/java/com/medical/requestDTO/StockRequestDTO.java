package com.medical.requestDTO;

import java.time.LocalDateTime;
import java.util.List;

import com.medical.entity.Product;

import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockRequestDTO {
	
	

	
	private String stockName;
	private Integer quantityAvailable;
	private LocalDateTime lastUpdated;
	private List<Product> products;
	
	

}
