package com.example.Individual.domain.persistence;

import com.example.Individual.domain.persistence.entity.OrderEntity;
import com.example.Individual.domain.persistence.entity.ProductEntity;

import java.util.List;
import java.util.Map;

public interface OrderRepository {
    void AddProduct(ProductEntity product, Integer quantity);
    void IncreaseQuantity(String SKU);
    void DecreaseQuantity(String SKU);
    void RemoveProduct(ProductEntity product);
    void RemoveAllProducts();
    void PayOrder();
    List<ProductEntity> GetAllProductsForOder(OrderEntity order);
    OrderEntity GetActiveOrder(String email);
    List<OrderEntity> GetPastOrdersForClient(String email);
}
