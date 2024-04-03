package com.medical.requestDTO;

import java.time.LocalDate;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestDto {
	     private Integer productId;
	    private String name;
	    private String description;
	    private String manufacturer;
	    private LocalDate expiryDate;
	    private double unitPrice;
	    private int quantityInStock;
	    private String category;
	    private String batchNumber;

	    private Integer stockId;
	   // private Stock stock;

	  
}
