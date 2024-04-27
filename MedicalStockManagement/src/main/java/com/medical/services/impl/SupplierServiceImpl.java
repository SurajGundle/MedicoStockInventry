package com.medical.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medical.RESTFUL.dto.request.SupplierRequestDto;
import com.medical.RESTFUL.dto.response.SupplierResponseDto;
import com.medical.RESTFUL.error.handler.SupplierException;
import com.medical.entities.Supplier;
import com.medical.services.SupplierService;
import com.medical.services.dao.repository.SupplierRepository;

@Service
public class SupplierServiceImpl implements SupplierService{

	@Autowired
	ModelMapper modelMapper;
	@Autowired
	SupplierRepository supplierRepository;

	@Override
	public SupplierResponseDto addSupplier(SupplierRequestDto supplierRequestDto) throws SupplierException {
		// TODO Auto-generated method stub
		Supplier addSupplier=modelMapper.map(supplierRequestDto, Supplier.class);
		 Supplier saveSupplier=supplierRepository.save(addSupplier);
		
		return modelMapper.map(saveSupplier, SupplierResponseDto.class);
	}

	@Override
	public SupplierResponseDto getSupplierById(Integer supplierId) throws SupplierException {
		// TODO Auto-generted method stub
		Optional<Supplier>opt= supplierRepository.findById(supplierId);
		
		return modelMapper.map(opt, SupplierResponseDto.class);
	}

	@Override
	public String deleteSupplierById(Integer supplierId) throws SupplierException {
		// TODO Auto-generated method stub
		Optional<Supplier>opt= supplierRepository.findById(supplierId);
		if(opt.isEmpty()) {
			throw new SupplierException("supplier not present for delete with ID :"+supplierId);
		}
		       supplierRepository.deleteById(supplierId);
		return "Delete supplier with : "+ supplierId;
	}

		public List<SupplierResponseDto> getAllSupplier() {
		// TODO Auto-generated method stub
	    	List<Supplier> suppplierList= supplierRepository.findAll();
			List<SupplierResponseDto> list=new ArrayList<>();
			for (Supplier supplier : suppplierList) {
				list.add(modelMapper.map(supplier, SupplierResponseDto.class)); 
			}
			return list;
			
		}

		@Override
		public SupplierResponseDto updateSupplierById(Integer supplierId, SupplierRequestDto suppliertRequestDto)
				throws SupplierException {
			// TODO Auto-generated method stub
			
			 Optional<Supplier> opt = supplierRepository.findById(supplierId);
			    if (opt.isEmpty()) {
			        throw new SupplierException("Supplier with ID " + supplierId + " not found");
			    }

			    Supplier existSupplier = opt.get();
			    existSupplier.setName(suppliertRequestDto.getName());
			    existSupplier.setOrderQuatity(suppliertRequestDto.getOrderQuatity());
			  //  existSupplier.setOrderDate(suppliertRequestDto.getOrderDate());
			//    existSupplier.setStocks(suppliertRequestDto.getStock());
			    
			    supplierRepository.save(existSupplier);
				
			    return modelMapper.map(existSupplier, SupplierResponseDto.class);

		}

}
	/*	public List<Stock> getStocksBySuppierId(Integer supplierId) throws SupplierException {
			// TODO Auto-generated method stub
		
		        Optional<Supplier> opt = supplierRepository.findById(supplierId);
		        if (opt.isEmpty()) {
		        	 throw new SupplierException("Supplier not found with id: " + supplierId);
		        }
		            Supplier supplier = opt.get();
		            return supplier.getStocks();
		        }
		}*/

	    
	
			
		


	
	


