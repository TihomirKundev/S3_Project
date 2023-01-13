package com.example.Individual.persistence.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface OrderRepository  extends JpaRepository<OrderEntity, Integer> {
    @Transactional
    @Modifying
    @Query("""
            update OrderEntity o set o.isItActive = false, o.totalPrice = ?1
            where o.clientEmail = ?2 and o.isItActive = true""")
    void updateIsItActiveAndTotalPriceByClientEmailAndIsItActiveTrue(double totalPrice, String clientEmail);
    @Query("select o from OrderEntity o where o.clientEmail = ?1 and o.isItActive = true")
    OrderEntity findClientActiveOrder(String clientEmail);
    @Query("select o from OrderEntity o where o.clientEmail = ?1 and o.isItActive = false")
    List<OrderEntity> findByClientEmailAndIsItActiveFalse(String clientEmail);
    @Query("select count(o) from OrderEntity o where o.orderNum is not null")
    long countByOrderNumNotNull();
    @Query("select count(o) from OrderEntity o where o.isItActive = false")
    long countByIsItActiveFalse();

    @Query("select o from OrderEntity o where o.isItActive = false")
    List<OrderEntity> findByIsItActiveFalse();
}
