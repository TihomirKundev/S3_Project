package com.example.Individual.business.impl;

import com.example.Individual.business.ContractEndDateValidator;
import com.example.Individual.business.exceptions.InvalidDateException;
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
