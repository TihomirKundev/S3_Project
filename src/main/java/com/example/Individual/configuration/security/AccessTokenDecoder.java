package com.example.Individual.configuration.security;

public interface AccessTokenDecoder {
    AccessToken decode(String accessTokenEncoded);
}
