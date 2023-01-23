package com.fiveExceptions.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService {
    public static final String SECRET = "452948404D6351665468576D5A7134743777217A25432A462D4A614E64526755";

    public String generateToken(String username) {
        Map<String, Object> claim = new HashMap<>();
       return createToken(claim, username);
    }

    private String createToken(Map<String, Object> claim, String username) {
        return Jwts.builder()
                .setClaims(claim)
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000*60*30))
                .signWith(signKey(), SignatureAlgorithm.HS256).compact();
    }

    private Key signKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);

    }
}
