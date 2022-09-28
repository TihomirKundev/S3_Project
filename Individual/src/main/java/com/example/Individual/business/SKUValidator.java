package com.example.Individual.business;

import com.example.Individual.business.exceptions.InvalidSKUException;

public interface SKUValidator {
    void validateSKUOnCreate(String SKU) throws InvalidSKUException;

    void validateSKUOnDelete(String SKU) throws InvalidSKUException;
}