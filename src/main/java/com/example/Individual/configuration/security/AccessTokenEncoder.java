package com.example.Individual.configuration.security;

public interface AccessTokenEncoder {
    String encode(AccessToken accessToken);
}
