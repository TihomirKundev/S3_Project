package com.example.Individual.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class InvalidDateException extends ResponseStatusException {
    public InvalidDateException(){
        super(HttpStatus.BAD_REQUEST, "End date is invalid!");
    }
}
