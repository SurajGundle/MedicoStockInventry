package com.medical.mapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.medical.entity.Bill;
import com.medical.entity.Product;
import com.medical.requestDTO.BillRequestDto;
import com.medical.requestDTO.ProductRequestDto;
import com.medical.responseDTO.BillResponseDto;


@Configuration
public class BillModelMapperConfig {
	
			@Bean
			public ModelMapper modelMapper() {
			    ModelMapper modelMapper = new ModelMapper();

			    // Mapping from BillRequestDto to Bill
			    modelMapper.createTypeMap(BillRequestDto.class, Bill.class)
			            .addMapping(BillRequestDto::getBillId, Bill::setBillId)
			            .addMapping(BillRequestDto::getBillDate, Bill::setBillDate)
			      //      .addMapping(BillRequestDto::getName, Bill::setName)
			            .addMapping(BillRequestDto::getPatientName, Bill::setPatientName)
			            .addMapping(BillRequestDto::getTotalAmount, Bill::setTotalAmount);

			    
			    
			    
			    modelMapper.createTypeMap(Bill.class, BillResponseDto.class)
			    .addMapping(Bill::getBillId, BillResponseDto::setBillId)
	            .addMapping(Bill::getBillDate, BillResponseDto::setBillDate)
	        //    .addMapping(Bill::getName, BillResponseDto::setName)
	            .addMapping(Bill::getPatientName, BillResponseDto::setPatientName)
	            .addMapping(Bill::getTotalAmount, BillResponseDto::setTotalAmount);
			    return modelMapper;
			}


	    /*    // Mapping from BillRequestDto to Bill
	        modelMapper.addMappings(new PropertyMap<BillRequestDto, Bill>() {
	            @Override
	            protected void configure() {
	               map().setBillId(source.getBillId());
	               map().setBillDate(source.getBillDate());
	              // map().setName(source.getName());
	               map().setPatientName(source.getPatientName());
	               map().setTotalAmount(source.getTotalAmount());
	            }
	        });

	        // Mapping from Bill to BillResponseDto
	        modelMapper.addMappings(new PropertyMap<Bill,BillResponseDto>() {
	            @Override
	           protected void configure(){
	               map().setBillId(source.getBillId());
	               map().setBillDate(source.getBillDate());
	              // map().setName(source.getName());
	               map().setPatientName(source.getPatientName());
	              map().setTotalAmount(source.getTotalAmount());
	           
	            }
	        });

	        return modelMapper;
	    }*/

	


}

