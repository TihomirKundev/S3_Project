package com.example.Individual.domain.persistence;

import com.example.Individual.domain.persistence.entity.OrderEntity;
import com.example.Individual.domain.persistence.entity.ProductEntity;

import java.util.Map;

public interface OrderItemRepository {
    void addProduct(ProductEntity product, Integer quantity);

    void increaseQuantity(String SKU);

    void decreaseQuantity(String SKU);

    void removeProduct(ProductEntity product);

    void removeAllProducts();

    Map<ProductEntity, Integer> getAllProductsForOder(OrderEntity order);
}
