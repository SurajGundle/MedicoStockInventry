package com.medical.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Supplier {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private  Integer supplierId;
    private String name;
    private Integer  orderQuatity; 
    private Date orderDate; 
    
    @OneToMany(mappedBy = "supplier")
    private List<Product> products;
	
}
