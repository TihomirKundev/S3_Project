package com.example.Individual.domain.persistence.dalImpl;

import com.example.Individual.domain.persistence.OrderItemRepository;
import com.example.Individual.domain.persistence.entity.OrderEntity;
import com.example.Individual.domain.persistence.entity.ProductEntity;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DALOrderItemRepositoryImpl implements OrderItemRepository {
    private final Map<ProductEntity, Integer> orderItems;

    public DALOrderItemRepositoryImpl(){
        this.orderItems = new HashMap<>();
    }
    @Override
    public void addProduct(ProductEntity product, Integer quantity) {
        orderItems.put(product, quantity);
    }

    @Override
    public void increaseQuantity(String SKU) {
        for(Map.Entry<ProductEntity,Integer> entry : orderItems.entrySet()){
            if(entry.getKey().getSKU().equals(SKU)){
                entry.setValue(entry.getValue() + 1);
            }
        }
    }

    @Override
    public void decreaseQuantity(String SKU) {
        for(Map.Entry<ProductEntity,Integer> entry : orderItems.entrySet()){
            if(entry.getKey().getSKU().equals(SKU)){
                entry.setValue(entry.getValue() - 1);
            }
        }
    }

    @Override
    public void removeProduct(ProductEntity product) {
        orderItems.remove(product);
    }

    @Override
    public void removeAllProducts() {
        orderItems.clear();
    }

    @Override
    public Map<ProductEntity, Integer> getAllProductsForOder(OrderEntity order) {
        return orderItems;
    }
}
