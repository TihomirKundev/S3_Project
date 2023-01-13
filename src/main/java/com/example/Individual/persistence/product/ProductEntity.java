package com.example.Individual.persistence.product;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Setter
@Getter
@Entity
@Table(name = "products")
public class ProductEntity {
    @Id
    @Column(name = "sku")
    private String sku;
    @NotNull
    @Column(name = "category")
    private String category;
    @NotNull
    @Column(name = "name")
    private String name;
    @NotNull
    @Column(name = "description")
    private String description;
    @NotNull
    @Column(name = "maker")
    private String maker;
    @NotNull
    @Column(name = "country_of_origin")
    private String countryOfOrigin;
    @NotNull
    @Column(name = "price")
    private Double price;
    @NotNull
    @Column(name = "weight")
    private Double weight;
}
