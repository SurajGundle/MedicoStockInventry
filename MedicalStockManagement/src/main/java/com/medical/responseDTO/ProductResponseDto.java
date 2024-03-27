package com.medical.responseDTO;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ProductResponseDto {
	  private Integer productId;
	   private String name;
	    private int quantityInStock;
	    private double unitPrice;
	    private LocalDate expiryDate;

}
