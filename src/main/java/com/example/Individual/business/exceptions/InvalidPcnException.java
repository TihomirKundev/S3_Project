package com.example.Individual.business.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class InvalidPcnException extends ResponseStatusException {
    public InvalidPcnException() {
        super(HttpStatus.BAD_REQUEST, "PCN is invalid");
    }
}