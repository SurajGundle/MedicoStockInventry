package com.medical.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
	   private String name;
	    private int quantityInStock;
	    private double unitPrice;
	    private LocalDate expiryDate;

}
