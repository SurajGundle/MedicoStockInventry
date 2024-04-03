package com.medical.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
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
    private LocalDate orderDate; 
	//@OneToMany(mappedBy = "supplierId", cascade = CascadeType.ALL)
	//  private List<Stock> stocks = new ArrayList<>();
	
	
}
