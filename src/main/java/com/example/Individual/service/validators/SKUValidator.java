package com.example.Individual.service.validators;

import com.example.Individual.service.exceptions.InvalidSKUException;

public interface SKUValidator {
    String validateSKUOnCreate(String SKU) throws InvalidSKUException;

    String validateSKUOnDelete(String SKU) throws InvalidSKUException;
}