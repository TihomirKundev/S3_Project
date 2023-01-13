package com.example.Individual.persistence.order;

import com.example.Individual.persistence.orderItem.OrderItemEntity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "orders")
public class OrderEntity {
    @NotNull
    @JoinColumn(name = "client_email")
    private String clientEmail;
    @Id
    @Column(name = "order_num")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderNum;
    @NotNull
    @OneToMany(mappedBy = "orderNum")
    private List<OrderItemEntity> items;
    @Setter(value = AccessLevel.PUBLIC)
    @NotNull
    @Column(name = "is_active")
    private boolean isItActive;
    @NotNull
    @Column(name = "total_price")
    private double totalPrice;

}
