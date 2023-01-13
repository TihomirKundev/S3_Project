package com.example.Individual.service.validators;

import com.example.Individual.service.exceptions.InvalidEmailException;

public interface EmailValidator {
    String validateEmailForCreateForStaff(String email) throws InvalidEmailException;
    String validateEmailForCreateForClient(String email) throws InvalidEmailException;

}
