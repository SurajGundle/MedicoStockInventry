package com.medical.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	    private Date expiryDate;
	    private double unitPrice;
	    private int quantityInStock;
	    private Category category;
	    
	    @ManyToOne
	    private Stock stock;

	    @ManyToOne
	    private Supplier supplier;
}
