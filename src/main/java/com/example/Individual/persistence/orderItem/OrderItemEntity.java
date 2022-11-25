package com.example.Individual.persistence.orderItem;

import com.example.Individual.persistence.product.ProductEntity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Setter(value = AccessLevel.PRIVATE)
@Getter
@Entity
@Table(name = "order_items")
public class OrderItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "order_orderNum")
    private int orderNum;
    @ManyToOne
    @JoinColumn(name = "product_sku")
    @NotNull
    private ProductEntity product;
    @NotNull
    @Column(name = "quantity")
    private int quantity;
}
