package com.example.Individual.business.impl;

import com.example.Individual.business.PriceValidator;
import com.example.Individual.business.exceptions.InvalidPriceException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PriceValidatorImpl implements PriceValidator {
    @Override
    public void validatePrice(Double price) throws InvalidPriceException {
        if(price == null || price <= 0.0){
            throw new InvalidPriceException();
        }
    }
}
