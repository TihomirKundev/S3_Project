package com.example.Individual.persistence.orderItem;

import com.example.Individual.persistence.product.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItemEntity, Integer> {
    @Query("select o from OrderItemEntity o where o.orderNum = ?1 and o.product = ?2")
    OrderItemEntity findByOrderNumAndProduct(int orderNum, ProductEntity product);
    @Query("select (count(o) > 0) from OrderItemEntity o where o.orderNum = ?1 and o.product = ?2")
    boolean existsByOrderNumAndProduct_Sku(int orderNum, ProductEntity product);

    @Transactional
    @Modifying
    @Query("update OrderItemEntity o set o.quantity = o.quantity + ?1 where o.orderNum = ?2 and o.product = ?3")
    void updateQuantityByOrderNumAndProduct(int quantity, int orderNum, ProductEntity product);

    @Query("select o from OrderItemEntity o where o.orderNum = ?1 and o.product.countryOfOrigin = ?2")
    List<OrderItemEntity> findByOrderNumAndProduct_CountryOfOrigin(int orderNum, String countryOfOrigin);

    @Query("select count(o) from OrderItemEntity o where o.id is not null")
    long countByIdNotNull();
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
