package com.example.Individual.configuration.security;

import com.example.Individual.configuration.exceptions.InvalidAccessTokenException;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class AccessTokenEncoderDecoderImpl implements AccessTokenEncoder,AccessTokenDecoder{
    private final Key key;

    public AccessTokenEncoderDecoderImpl(@Value("${jwt.secret}") String secretKey){
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        this.key = Keys.hmacShaKeyFor(keyBytes);
    }
    @Override
    public AccessToken decode(String accessTokenEncoded) {
        try {
            Jwts.builder()
                    .setSubject("User login")
                    .signWith(key)
                    .compact();
            Claims claims = (Claims) Jwts.parserBuilder().setSigningKey(key).build().parse(accessTokenEncoded).getBody();
            return AccessToken.builder()
                    .email(claims.get("email",String.class))
                    .role(claims.get("role",  Roles.class))
                    .build();
        } catch (JwtException e) {
            throw new InvalidAccessTokenException(e.getMessage());
        }
    }

    @Override
    public String encode(AccessToken accessToken) {
        Map<String, Object> claimsMap = new HashMap<>();
        if(accessToken.getEmail() != null && accessToken.getEmail().length() != 0){
            claimsMap.put("email", accessToken.getEmail());
        }
        if(accessToken.getRole() != null){
            claimsMap.put("role", accessToken.getRole());
        }
        Instant now = Instant.now();
        return Jwts.builder()
                .setIssuedAt(Date.from(now))
                .setExpiration(Date.from(now.plus(30, ChronoUnit.MINUTES)))
                .addClaims(claimsMap)
                .signWith(key)
                .compact();
    }
}
