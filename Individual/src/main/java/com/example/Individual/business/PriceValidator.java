package com.example.Individual.business;

import com.example.Individual.business.exceptions.InvalidPriceException;

public interface PriceValidator {
    void validatePrice(Double price) throws InvalidPriceException;
}
