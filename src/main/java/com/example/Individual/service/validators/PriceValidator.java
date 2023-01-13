package com.example.Individual.service.validators;

import com.example.Individual.service.exceptions.InvalidPriceException;

public interface PriceValidator {
    String validatePrice(Double price) throws InvalidPriceException;
}
