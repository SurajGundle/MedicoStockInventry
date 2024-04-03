package com.medical.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.medical.entity.Product;
import com.medical.requestDTO.ProductRequestDto;
import com.medical.responseDTO.ProductResponseDto;




@Configuration
public class ProductModelMapperConfig {

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


                

        
        return modelMapper;
    
    }

}



