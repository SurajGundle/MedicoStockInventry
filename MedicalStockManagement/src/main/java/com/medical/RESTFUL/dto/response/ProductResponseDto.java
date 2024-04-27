package com.medical.RESTFUL.dto.response;

import java.time.LocalDate;


import lombok.Data;

@Data
public class ProductResponseDto {
	  private Integer productId;
	   private String name;
	    private int quantityInStock;
	    private String description;
	    private double unitPrice;
	    private LocalDate expiryDate;
	    private String category;
	    private String batchNumber;
	     private Integer stockId;
	     private String manufacturer;

         
	    //private Stock stock;

}
