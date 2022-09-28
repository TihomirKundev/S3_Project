package com.example.Individual.business.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class InvalidSKUException extends ResponseStatusException {
    public InvalidSKUException() {
        super(HttpStatus.BAD_REQUEST, "SKU is invalid");
    }
}