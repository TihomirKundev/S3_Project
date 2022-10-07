package com.example.Individual.business;

import com.example.Individual.business.exceptions.InvalidDateException;

import java.util.Date;

public interface ContractEndDateValidator {
    void validateDate(Date contractEndDate) throws InvalidDateException;
}
