package com.example.Individual.service.validators.impl;

import com.example.Individual.persistence.client.ClientRepository;
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
    private final ClientRepository clientRepository;
    @Transactional
    public String validateEmailForCreateForStaff(String email) throws InvalidEmailException {
        if (email.isEmpty() || this.staffRepository.existsByEmail(email)) {
            throw new InvalidEmailException();
        }
        return "Email is right";
    }
    @Transactional
    public String validateEmailForCreateForClient(String email) throws InvalidEmailException {
        if (email.isEmpty() || this.clientRepository.existsByEmail(email)) {
            throw new InvalidEmailException();
        }
        return "Email is right";
    }
}