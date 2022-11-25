package com.example.Individual.configuration.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class InvalidAccessTokenException extends ResponseStatusException {
    public InvalidAccessTokenException(String error){
        super(HttpStatus.UNAUTHORIZED, error);
    }
}
