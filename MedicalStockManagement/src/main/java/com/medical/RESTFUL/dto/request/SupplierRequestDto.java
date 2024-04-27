package com.medical.RESTFUL.dto.request;

import java.time.LocalDate;
import java.util.List;

import com.medical.entities.Stock;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupplierRequestDto {
	   private Integer supplierId;
	    private String name;
	    private Integer  orderQuatity; 
	    private LocalDate orderDate; 
		
		 private List<Stock> stock;
		
		//private Integer stockId;

}
