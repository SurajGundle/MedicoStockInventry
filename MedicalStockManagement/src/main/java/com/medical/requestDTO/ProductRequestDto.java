package com.medical.requestDTO;

import java.time.LocalDate;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestDto {
	
	/*
	 *   private String name;
	    private String description;
	    private String manufacturer;
	    private Date expiryDate;
	    private double unitPrice;
	    private int quantityInStock;
	    private String category;
	    private Stock stock;
	    private Supplier supplier;
	    */
	    private String name;
	    private String description;
	    private String manufacturer;
	    private LocalDate expiryDate;
	    private double unitPrice;
	    private int quantityInStock;
	    private String category;
	    private Integer stock;

	    private Integer stockId;
	    private Integer supplierId;

	  
}
