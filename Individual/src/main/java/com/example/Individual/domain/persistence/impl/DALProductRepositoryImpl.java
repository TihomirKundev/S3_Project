package com.example.Individual.domain.persistence.impl;

import com.example.Individual.domain.persistence.ProductRepository;
import com.example.Individual.domain.persistence.entity.ProductEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DALProductRepositoryImpl implements ProductRepository {
    private final List<ProductEntity> products;

    public DALProductRepositoryImpl() { this.products = new ArrayList<>();}

    public void Create(ProductEntity product) {
        this.products.add(product);
    }

    public void Update(ProductEntity product) {
    }

    public void Delete(String SKU) {
        ProductEntity product = (ProductEntity)this.products.stream().filter((x) -> {
            return x.getSKU().equals(SKU);
        }).findFirst().orElse(null);
        this.products.remove(product);
    }

    public List<ProductEntity> GetAll() {
        return this.products;
    }

    public int Count() {
        return this.products.size();
    }

    public boolean ExistsBySKU(String SKU) {
        return this.products.stream().anyMatch((x) -> {
            return x.getSKU().equals(SKU);
        });
    }

    public ProductEntity GetProduct(String SKU) {
        return (ProductEntity)this.products.stream().filter((x) -> {
            return x.getSKU().equals(SKU);
        }).findFirst().orElse(null);
    }
}

