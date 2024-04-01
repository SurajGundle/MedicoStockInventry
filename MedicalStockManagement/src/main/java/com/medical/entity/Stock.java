package com.medical.entity;

import java.time.LocalDateTime;
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

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stock {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer stockId;
	private String stockName;
	private Integer quantityAvailable;
	private LocalDateTime lastUpdated;
	
	@OneToMany(mappedBy = "stockId", cascade = CascadeType.ALL)
	//@OneToMany(mappedBy="stock",cascade=CascadeType.ALL)
	 private List<Product> products = new ArrayList<>();

}
