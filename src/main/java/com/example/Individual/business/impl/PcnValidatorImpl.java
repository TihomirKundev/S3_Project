package com.example.Individual.business.impl;

import com.example.Individual.business.PcnValidator;
import com.example.Individual.business.exceptions.InvalidPcnException;
import com.example.Individual.domain.persistence.StaffRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PcnValidatorImpl implements PcnValidator {
    private final StaffRepository staffRepository;

    public void validatePcnForCreate(Long pcn) throws InvalidPcnException {
        if (pcn == null || this.staffRepository.existByPcn(pcn)) {
            throw new InvalidPcnException();
        }
    }

    public void validatePcnForDelete(Long pcn) throws InvalidPcnException {
        if (pcn == null || !this.staffRepository.existByPcn(pcn)) {
            throw new InvalidPcnException();
        }
    }
}