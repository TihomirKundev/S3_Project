package com.example.Individual.persistence.order;

import lombok.AllArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
public class OrderPK implements Serializable {
    private String clientEmail;
    private int orderNum;
}
