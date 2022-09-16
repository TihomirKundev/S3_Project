package com.example.Individual.business.impl;

import com.example.Individual.domain.Product;
import com.example.Individual.domain.persistence.entity.ProductEntity;

public class ProductConverter {
    private ProductConverter(){
    }

    public static Product Convert(ProductEntity productEntity){
        return Product.builder()
                .SKU(productEntity.getSKU())
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
