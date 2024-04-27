package com.medical.RESTFUL.dto.response;

import java.time.LocalDate;
import java.util.List;

import com.medical.entities.Stock;

import lombok.Data;

@Data
public class SupplierResponseDto {
	private Integer supplierId;
	  private String name;
	    private Integer  orderQuatity; 
	    private LocalDate orderDate; 
		
		 private List<Stock> stock;
		
   //  private Integer stockId;
}
