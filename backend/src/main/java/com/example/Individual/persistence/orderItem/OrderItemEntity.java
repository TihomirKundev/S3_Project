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
    @Column(name = "id")
    private int id;
    @NotNull
    @JoinColumn(name = "order_num")
    private int orderNum;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "product_sku")
    private ProductEntity product;
    @NotNull
    @Column(name = "quantity")
    private int quantity;
}
