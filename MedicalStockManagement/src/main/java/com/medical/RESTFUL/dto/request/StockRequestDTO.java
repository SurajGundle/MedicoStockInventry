package com.medical.RESTFUL.dto.request;

import java.time.LocalDateTime;
import java.util.List;

import com.medical.entities.Product;

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
	private Integer supplierId;
	

}
