package com.medical.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
	    private Double price;
	    private Integer quantity;

	    @ManyToOne
	    @JoinColumn(name = "stock_id", nullable = false)
	    private Stock stock;

	    @ManyToOne
	    @JoinColumn(name = "supplier_id", nullable = false)
	    private Supplier supplier;
}
