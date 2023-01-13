package com.example.Individual.dto.entities;

import com.example.Individual.persistence.orderItem.OrderItemEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    String clientEmail;
    int orderNum;
    List<OrderItemEntity> products;
    boolean isItActive;
    double totalPrice;
}
