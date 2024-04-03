package com.medical.mapper;


import org.modelmapper.ModelMapper;

import org.springframework.context.annotation.Configuration;

import com.medical.entity.Supplier;

import com.medical.requestDTO.SupplierRequestDto;
import com.medical.responseDTO.SupplierResponseDto;



@Configuration
public class SuppilerModelMapperConfig {
	   public ModelMapper modelMapper() {
	        ModelMapper modelMapper = new ModelMapper();
	      

	        modelMapper.createTypeMap(SupplierRequestDto.class, Supplier.class)
           .addMapping(SupplierRequestDto::getName, Supplier::setName)
            .addMapping(SupplierRequestDto::getOrderDate, Supplier::setOrderDate)
            .addMapping(SupplierRequestDto::getSupplierId, Supplier::setSupplierId)
      
            .addMapping(SupplierRequestDto::getOrderQuatity, Supplier::setOrderQuatity);
            
	        
            modelMapper.createTypeMap(Supplier.class, SupplierResponseDto.class)
            .addMapping(Supplier::getName, SupplierResponseDto::setName)
            .addMapping(Supplier::getOrderDate, SupplierResponseDto::setOrderDate)
            .addMapping(Supplier::getSupplierId, SupplierResponseDto::setSupplierId)
            .addMapping(Supplier::getOrderQuatity, SupplierResponseDto::setOrderQuatity);
    
	        
	        return modelMapper;
	   }

}
