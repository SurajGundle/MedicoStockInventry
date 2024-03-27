package com.medical.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medical.entity.Stock;
import com.medical.exception.StockException;
import com.medical.requestDTO.StockRequestDTO;
import com.medical.responseDTO.StockResponseDTO;
import com.medical.service.StockService;

@RestController
@RequestMapping("/stock")
public class StockController {
	@Autowired
	private StockService stockService;
	
	@PostMapping("/addNewStock")
	public ResponseEntity<StockResponseDTO> saveNewStock(@RequestBody StockRequestDTO stockRequestDTO) throws StockException {
		return new ResponseEntity<>(stockService.addStock(stockRequestDTO),HttpStatus.CREATED) ;
	}
	@GetMapping("/get/{stockId}")
	public ResponseEntity<StockResponseDTO> getStockById(@PathVariable("stockId") Integer stockId) throws StockException {
		return new ResponseEntity<>(stockService.getStockById(stockId),HttpStatus.FOUND);
	}
	@PutMapping("/update/{stockId}")
	public ResponseEntity<StockResponseDTO> updateStock(@PathVariable("stickId") Integer stockId,@RequestBody StockRequestDTO stockRequestDTO) throws StockException {
		return new ResponseEntity<>(stockService.updateStockById(stockId, stockRequestDTO),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{stockId}")
	public ResponseEntity<String> deleteStockById(@PathVariable("stickId") Integer stockId) throws StockException {
		return new ResponseEntity<>(stockService.deleteStockById(stockId),HttpStatus.OK);
	}
	
	@GetMapping("/getAllStocks")
	public ResponseEntity<List<StockResponseDTO>> getAllStockDetails() {
		return new ResponseEntity<>(stockService.getAllStock(),HttpStatus.FOUND);
	}
	

}
