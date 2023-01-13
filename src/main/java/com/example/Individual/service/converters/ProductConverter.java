package com.example.Individual.service.converters;

import com.example.Individual.dto.entities.Product;
import com.example.Individual.persistence.product.ProductEntity;

public class ProductConverter {
    private ProductConverter(){
    }

    public static Product Convert(ProductEntity productEntity){
        return Product.builder()
                .SKU(productEntity.getSku())
                .category(productEntity.getCategory())
                .name(productEntity.getName())
                .description(productEntity.getDescription())
                .maker(productEntity.getMaker())
                .countryOfOrigin(productEntity.getCountryOfOrigin())
                .price(productEntity.getPrice())
                .weight(productEntity.getWeight())
                .build();
    }
}
