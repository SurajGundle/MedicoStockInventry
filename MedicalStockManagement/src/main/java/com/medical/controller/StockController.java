package com.medical.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medical.entity.Stock;
import com.medical.responseDTO.StockResponseDTO;
import com.medical.service.StockService;

@RestController
@RequestMapping("/stock")
public class StockController {
	@Autowired
	StockService stockService;
	@PostMapping("/addNewStock")
	public StockResponseDTO saveNewStock(@RequestBody Stock stock) {
		return null;
	}
	@GetMapping("/get/{stockId}")
	public StockResponseDTO getStockById(@PathVariable("stockId") Integer stockId) {
		return null;
	}
	@PutMapping("/update/{stockId}")
	public StockResponseDTO updateStock(@PathVariable("stickId") Integer stockId,@RequestBody Stock stock) {
		return null;
	}
	
	@DeleteMapping("/delete/{stockId}")
	public StockResponseDTO deleteStockById(@PathVariable("stickId") Integer stockId) {
		return null;
	}
	
	@GetMapping("/getAllStocks")
	public List<StockResponseDTO> getAllStockDetails() {
		return null;
	}
	

}
