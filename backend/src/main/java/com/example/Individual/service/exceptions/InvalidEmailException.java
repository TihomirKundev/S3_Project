package com.example.Individual.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class InvalidEmailException extends ResponseStatusException {
    public InvalidEmailException() {
        super(HttpStatus.BAD_REQUEST, "Email is invalid");
    }
}