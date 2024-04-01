package com.medical.requestDTO;

import java.time.LocalDate;

import com.medical.entity.Stock;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestDto {
	
	    private String name;
	    private String description;
	    private String manufacturer;
	    private LocalDate expiryDate;
	    private double unitPrice;
	    private int quantityInStock;
	    private String category;
	    private String batchNumber;
<<<<<<< HEAD
	    private Integer stockId;
	   // private Stock stock;
=======
	    private Stock stock;
	    
>>>>>>> 2b2432edd8838d0c61d2d79acbc13a73b572ae75
	  
}
