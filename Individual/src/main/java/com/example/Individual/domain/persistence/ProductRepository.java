package com.example.Individual.domain.persistence;

import com.example.Individual.domain.persistence.entity.ProductEntity;

import java.util.List;

public interface ProductRepository {
    void Create(ProductEntity product);

    void Update(String SKU, String description, Double price);

    void Delete(String SKU);

    List<ProductEntity> GetAll();

    int Count();

    boolean ExistsBySKU(String SKU);

    ProductEntity GetProduct(String SKU);
}
