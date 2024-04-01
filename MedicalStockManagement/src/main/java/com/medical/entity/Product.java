package com.medical.entity;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	 //   private Stock stock;
	    private Integer stockId;
	    
}
