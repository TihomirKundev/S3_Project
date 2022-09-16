package com.example.Individual.domain.persistence;

import com.example.Individual.domain.persistence.entity.ProductEntity;

import java.util.List;

public interface ProductRepository {
    void Create(ProductEntity product);
    void Update(ProductEntity product);
    void Delete(String SKU);
    List<ProductEntity> GetAll();
    int Count();
}
