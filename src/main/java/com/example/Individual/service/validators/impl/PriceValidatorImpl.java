package com.example.Individual.service.validators.impl;

import com.example.Individual.service.validators.PriceValidator;
import com.example.Individual.service.exceptions.InvalidPriceException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PriceValidatorImpl implements PriceValidator {
    @Override
    public String validatePrice(Double price) throws InvalidPriceException {
        if(price == null || price <= 0.0){
            throw new InvalidPriceException();
        }
        return "Success";
    }
}
