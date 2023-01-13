package com.example.Individual.persistence.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ProductRepository extends JpaRepository<ProductEntity,String> {
    @Query("select count(p) from ProductEntity p where p.sku is not null")
    long countBySKUNotNull();
    @Transactional
    @Modifying
    @Query("update ProductEntity p set p.description = ?1, p.price = ?2 where p.sku = ?3")
    void updateDescriptionAndPriceBySKU(String description, Double price, String SKU);

    @Transactional
    @Modifying
    @Query("delete from ProductEntity p where p.sku = ?1")
    void deleteBySku(String sku);

    @Query("select (count(p) > 0) from ProductEntity p where p.sku = ?1")
    boolean existsBySku(String sku);

    //Optional<ProductEntity> findBySKU(String SKU);
}
