package com.example.Individual.persistence.orderItem;

import com.example.Individual.persistence.product.ProductEntity;
import lombok.AllArgsConstructor;

import java.io.Serializable;
@AllArgsConstructor
public class OrderItemPK implements Serializable {
    private int orderNum;
    private ProductEntity product;
}
