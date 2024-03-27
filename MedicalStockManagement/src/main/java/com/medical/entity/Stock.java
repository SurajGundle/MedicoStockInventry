package com.medical.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
//	private String stockName;
	private Integer quantityAvailable;
	private LocalDateTime lastUpdated;
	@OneToMany()
	private List<Product1> products;
	

}