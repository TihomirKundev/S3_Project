package com.example.Individual.business.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class InvalidPriceException extends ResponseStatusException {
    public InvalidPriceException(){
        super(HttpStatus.BAD_REQUEST,"Invalid price!");
    }
}
