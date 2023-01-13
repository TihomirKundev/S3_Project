package com.example.Individual.service.validators.impl;

import com.example.Individual.service.validators.ContractEndDateValidator;
import com.example.Individual.service.exceptions.InvalidDateException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@AllArgsConstructor
public class ContractEndDateValidatorImpl implements ContractEndDateValidator {
    @Override
    public void validateDate(Date contractEndDate) throws InvalidDateException {
        long millis = System.currentTimeMillis();
        Date date = new Date(millis);
        if(contractEndDate.before(date)){
            throw new InvalidDateException();
        }
    }
}
