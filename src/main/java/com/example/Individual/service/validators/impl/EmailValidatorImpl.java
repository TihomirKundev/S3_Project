package com.example.Individual.service.validators.impl;

import com.example.Individual.service.validators.EmailValidator;
import com.example.Individual.service.exceptions.InvalidEmailException;
import com.example.Individual.persistence.staff.StaffRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@AllArgsConstructor
public class EmailValidatorImpl implements EmailValidator {
    private final StaffRepository staffRepository;

    @Transactional
    public String validateEmailForCreate(String email) throws InvalidEmailException {
        if (email.isEmpty() || this.staffRepository.existsByEmail(email)) {
            throw new InvalidEmailException();
        }
        return "Email is right";
    }
}