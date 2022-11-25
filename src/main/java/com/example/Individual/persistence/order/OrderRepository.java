package com.example.Individual.persistence.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface OrderRepository  extends JpaRepository<OrderEntity, OrderPK> {
    @Query("select o from OrderEntity o where o.clientEmail = ?1 and o.isItActive = false")
    List<OrderEntity> findByClientEmailAndIsItActiveFalse(String clientEmail);
    @Query("select count(o) from OrderEntity o where o.orderNum is not null")
    long countByOrderNumNotNull();
    @Transactional
    @Modifying
    @Query("update OrderEntity o set o.isItActive = false where o.clientEmail = ?1 and o.isItActive = true")
    void updateIsItActiveByClientEmailAndIsItActiveTrue(String clientEmail);
    @Query("select o from OrderEntity o where o.clientEmail = ?1 and o.isItActive = true")
    Optional<OrderEntity> findByClientEmailAndIsItActiveTrue(String clientEmail);
}
