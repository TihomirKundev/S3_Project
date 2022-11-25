package com.example.Individual.service.validators;

import com.example.Individual.service.exceptions.InvalidEmailException;

public interface EmailValidator {
    String validateEmailForCreate(String email) throws InvalidEmailException;
}
