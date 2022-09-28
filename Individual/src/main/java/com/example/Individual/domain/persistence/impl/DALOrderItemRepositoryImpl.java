package com.example.Individual.domain.persistence.impl;

import com.example.Individual.domain.persistence.OrderItemRepository;
import com.example.Individual.domain.persistence.entity.OrderEntity;
import com.example.Individual.domain.persistence.entity.ProductEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class DALOrderItemRepositoryImpl implements OrderItemRepository {
    @Override
    public void AddProduct(ProductEntity product, Integer quantity) {

    }

    @Override
    public void IncreaseQuantity(String SKU) {

    }

    @Override
    public void DecreaseQuantity(String SKU) {

    }

    @Override
    public void RemoveProduct(ProductEntity product) {

    }

    @Override
    public void RemoveAllProducts() {

    }

    @Override
    public List<ProductEntity> GetAllProductsForOder(OrderEntity order) {
        return null;
    }
}
