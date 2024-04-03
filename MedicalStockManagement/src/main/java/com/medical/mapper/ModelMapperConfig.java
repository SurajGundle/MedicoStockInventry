package com.medical.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.medical.entity.Product;
import com.medical.entity.Stock;
import com.medical.requestDTO.ProductRequestDto;
import com.medical.requestDTO.StockRequestDTO;
import com.medical.responseDTO.ProductResponseDto;
import com.medical.responseDTO.StockResponseDTO;



@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        // Mapping from ProductRequestDto to Product
        modelMapper.createTypeMap(ProductRequestDto.class, Product.class)
                .addMapping(ProductRequestDto::getName, Product::setName)
                .addMapping(ProductRequestDto::getQuantityInStock, Product:: setQuantityInStock)
                .addMapping(ProductRequestDto::getUnitPrice, Product::setUnitPrice)
                .addMapping(ProductRequestDto::getExpiryDate, Product::setExpiryDate)
              .addMapping(ProductRequestDto::getDescription, Product::setDescription)
              .addMapping(ProductRequestDto::getCategory, Product::setCategory)

        .addMapping(ProductRequestDto::getManufacturer, Product::setManufacturer)

            
              .addMapping(ProductRequestDto::getStockId, Product::setStockId);
        

              

        // Mapping from Product to ProductResponseDto
        modelMapper.createTypeMap(Product.class, ProductResponseDto.class)
                .addMapping(Product::getProductId, ProductResponseDto::setProductId)
                .addMapping(Product::getName, ProductResponseDto::setName)
                .addMapping(Product::getUnitPrice, ProductResponseDto::setUnitPrice)
                .addMapping(Product::getExpiryDate, ProductResponseDto::setExpiryDate)
               .addMapping(Product::getDescription, ProductResponseDto::setDescription)
              .addMapping(Product::getCategory, ProductResponseDto::setCategory)
                .addMapping(Product::getQuantityInStock, ProductResponseDto::setQuantityInStock)
              .addMapping(Product::getManufacturer, ProductResponseDto::setManufacturer)
                .addMapping(Product::getStockId, ProductResponseDto::setStockId);


                

        // Mapping from StockRequestDTO to Stock
        modelMapper.createTypeMap(StockRequestDTO.class, Stock.class)
                .addMapping(StockRequestDTO::getQuantityAvailable, Stock::setQuantityAvailable)
                .addMapping(StockRequestDTO::getLastUpdated, Stock::setLastUpdated);
        
        
                
        
        //Mapping from stock to StockResponseDTO
        modelMapper.createTypeMap(Stock.class, StockResponseDTO.class)
        .addMapping(Stock::getStockId, StockResponseDTO::setStockId)
        .addMapping(Stock::getQuantityAvailable, StockResponseDTO::setQuantityAvailable)
        .addMapping(Stock::getLastUpdated, StockResponseDTO::setLastUpdated);
        
         
        return modelMapper;
    
    }

}



