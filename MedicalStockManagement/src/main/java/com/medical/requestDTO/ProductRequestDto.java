package com.medical.requestDTO;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ProductRequestDto {
	    private String name;
	    private int quantityInStock;
	    private double unitPrice;
	    private LocalDate expiryDate;
	  
}
