package com.medical.services.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medical.entities.Stock;

public interface StockRepository extends JpaRepository<Stock, Integer> {

}
