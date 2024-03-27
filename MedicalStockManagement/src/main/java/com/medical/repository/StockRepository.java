package com.medical.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medical.entity.Stock;

public interface StockRepository extends JpaRepository<Stock, Integer> {

}
