package com.example.Individual.service.validators;

import com.example.Individual.service.exceptions.InvalidDateException;

import java.util.Date;

public interface ContractEndDateValidator {
    void validateDate(Date contractEndDate) throws InvalidDateException;
}
