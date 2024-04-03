package com.medical.service;

import java.util.List;

import com.medical.entity.Stock;

import com.medical.exception.SupplierException;

import com.medical.requestDTO.SupplierRequestDto;

import com.medical.responseDTO.SupplierResponseDto;

public interface SupplierService {
	
	
	SupplierResponseDto addSupplier(SupplierRequestDto supplierRequestDto ) throws SupplierException;
	SupplierResponseDto getSupplierById(Integer supplierId) throws SupplierException;
	String deleteSupplierById(Integer supplierId) throws SupplierException;
	SupplierResponseDto updateSupplierById(Integer supplierId,SupplierRequestDto suppliertRequestDto ) throws SupplierException;
	List<SupplierResponseDto> getAllSupplier();
	// List<Stock> getStocksBySuppierId(Integer supplierId) throws SupplierException;


}
