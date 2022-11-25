package com.example.Individual.persistence.orderItem;

import com.example.Individual.persistence.product.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItemEntity, OrderItemPK> {
    @Transactional
    @Modifying
    @Query("update OrderItemEntity o set o.quantity = o.quantity + 1 where o.orderNum = ?1 and o.product = ?2")
    void updateQuantityByProductIncrease(int orderNum, ProductEntity product);

    @Transactional
    @Modifying
    @Query("update OrderItemEntity o set o.quantity = o.quantity - 1 where o.orderNum = ?1 and o.product = ?2")
    void updateQuantityByProductDecrease(int orderNum, ProductEntity product);

    @Transactional
    @Modifying
    @Query("delete from OrderItemEntity o where o.orderNum = ?1 and o.product = ?2")
    void deleteByOrderNumAndProduct(int orderNum, ProductEntity product);

    @Query("select o from OrderItemEntity o where o.orderNum = ?1")
    List<OrderItemEntity> findByOrderNum(int orderNum);

    @Transactional
    @Modifying
    @Query("delete from OrderItemEntity o where o.orderNum = ?1")
    void deleteByOrderNum(int orderNum);
}
