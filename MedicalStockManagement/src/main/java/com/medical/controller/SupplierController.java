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
import com.medical.exception.SupplierException;
import com.medical.requestDTO.SupplierRequestDto;
import com.medical.responseDTO.SupplierResponseDto;
import com.medical.service.SupplierService;



@RestController
@RequestMapping("/supplier")
public class SupplierController {
	@Autowired
	SupplierService supplierservice;

	@PostMapping("/addSupplier")
	public ResponseEntity<SupplierResponseDto> saveNewStock(@RequestBody SupplierRequestDto stockRequestDTO) throws SupplierException {
	    SupplierResponseDto savedStock = supplierservice.addSupplier(stockRequestDTO);
	    return new ResponseEntity<>(savedStock, HttpStatus.CREATED);
	}
	@GetMapping("/getSupplier/{supplierId}")
	
	public ResponseEntity<SupplierResponseDto>getSuppilerById(@PathVariable ("supplierId") Integer supplierId) throws SupplierException{
		return new ResponseEntity<>(supplierservice.getSupplierById(supplierId),HttpStatus.FOUND);
		}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<SupplierResponseDto>>getAll(){
		return new ResponseEntity<>(supplierservice.getAllSupplier(),HttpStatus.FOUND);
		
	}
	
	@DeleteMapping("/delete/{supplierId}")
    public ResponseEntity<String> deleteSupplierById(@PathVariable("supplierId") Integer supplierId) throws SupplierException{
	return new ResponseEntity<>(supplierservice.deleteSupplierById(supplierId),HttpStatus.OK);
    }
	@PutMapping("/update/{supplierId}")
	public ResponseEntity<SupplierResponseDto> updateSupplier(@PathVariable("supplierId") Integer supplierId,@RequestBody SupplierRequestDto supplierRequestDto) throws  SupplierException {
		return new ResponseEntity<>(supplierservice.updateSupplierById(supplierId, supplierRequestDto),HttpStatus.OK);
	}
	
		
	}

