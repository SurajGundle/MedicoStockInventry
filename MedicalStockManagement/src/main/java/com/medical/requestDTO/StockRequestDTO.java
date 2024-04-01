package com.medical.requestDTO;

import java.time.LocalDateTime;
import java.util.List;

import com.medical.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockRequestDTO {
<<<<<<< HEAD
=======

>>>>>>> 2b2432edd8838d0c61d2d79acbc13a73b572ae75
	private String stockName;
	private Integer quantityAvailable;
	private LocalDateTime lastUpdated;
	private List<Product> products;
	
	

}
