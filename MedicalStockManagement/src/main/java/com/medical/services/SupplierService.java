package com.medical.services;

import java.util.List;

import com.medical.RESTFUL.dto.request.SupplierRequestDto;
import com.medical.RESTFUL.dto.response.SupplierResponseDto;
import com.medical.RESTFUL.error.handler.SupplierException;

public interface SupplierService {

	SupplierResponseDto addSupplier(SupplierRequestDto supplierRequestDto) throws SupplierException;

	SupplierResponseDto getSupplierById(Integer supplierId) throws SupplierException;

	String deleteSupplierById(Integer supplierId) throws SupplierException;

	SupplierResponseDto updateSupplierById(Integer supplierId, SupplierRequestDto suppliertRequestDto)
			throws SupplierException;

	List<SupplierResponseDto> getAllSupplier();
	

}
