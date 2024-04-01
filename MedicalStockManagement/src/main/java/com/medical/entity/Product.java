package com.medical.entity;

import java.time.LocalDate;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
<<<<<<< HEAD
        private Integer productId;
	    private String name;
	    private String description;
	    private String manufacturer;
	    private LocalDate expiryDate;
	    private double unitPrice;
	    private int quantityInStock;
	    private String category;
	    private String batchNumber;
	    
	   // @ManyToOne
	    @JoinColumn(name = "stockId") 
	   private Integer stockId;
	    // private Stock stock;
=======
	private Integer productId;
    private String name;
    private String description;
    private String manufacturer;
    private LocalDate expiryDate;
    private double unitPrice;
    private int quantityInStock;
    private String category;
    private String batchNumber;
 
    @ManyToOne
    @JoinColumn(name = "stock_id") 
    private Stock stock; 
>>>>>>> 2b2432edd8838d0c61d2d79acbc13a73b572ae75
	    
}
