package com.medical.mapper;

import java.time.LocalDate;
import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.medical.dto.ProductDto;
import com.medical.entity.Product;
import com.medical.entity.Stock;
import com.medical.entity.Supplier;
import com.medical.repository.StockRepository;
import com.medical.requestDTO.ProductRequestDto;
import com.medical.responseDTO.ProductResponseDto;

import jakarta.persistence.ManyToOne;





public class ProductModelMapperConfig {
	
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        
     
      
        // Mapping from ProductRequestDto to Product
        modelMapper.createTypeMap(ProductRequestDto.class, Product.class)
        // need to work as company dto
     
                .addMapping(ProductRequestDto::getName, Product::setName)
                .addMapping(ProductRequestDto::getDescription, Product::setDescription)
                .addMapping(ProductRequestDto::getManufacturer, Product::setManufacturer)
                .addMapping(ProductRequestDto::getExpiryDate, Product::setExpiryDate)
                .addMapping(ProductRequestDto::getUnitPrice, Product::setUnitPrice)
                .addMapping(ProductRequestDto::getQuantityInStock, Product:: setQuantityInStock)
                .addMapping(ProductRequestDto::getCategory, Product::setCategory)
                .addMapping(ProductRequestDto::getStock, Product::setStock)
                
                
              
              .addMapping(ProductRequestDto::getCategory, Product::setCategory);

        

            
              //.addMapping(ProductRequestDto::getStockId, Product::setStockId);
        

              

        // Mapping from Product to ProductResponseDto
        modelMapper.createTypeMap(Product.class, ProductResponseDto.class)
                .addMapping(Product::getProductId, ProductResponseDto::setProductId)
                .addMapping(Product::getName, ProductResponseDto::setName)
                .addMapping(Product::getUnitPrice, ProductResponseDto::setUnitPrice)
                .addMapping(Product::getExpiryDate, ProductResponseDto::setExpiryDate)
               .addMapping(Product::getDescription, ProductResponseDto::setDescription)
              .addMapping(Product::getCategory, ProductResponseDto::setCategory)
                .addMapping(Product::getQuantityInStock, ProductResponseDto::setQuantityInStock)
              .addMapping(Product::getManufacturer, ProductResponseDto::setManufacturer);
               // .addMapping(Product::getStockId, ProductResponseDto::setStockId);


                

        
        return modelMapper;
    
    }

}



