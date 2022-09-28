package com.example.Individual.business;

import com.example.Individual.business.exceptions.InvalidPcnException;

public interface PcnValidator {
    void validatePcnForCreate(Long pcn) throws InvalidPcnException;

    void validatePcnForDelete(Long pcn) throws InvalidPcnException;
}
