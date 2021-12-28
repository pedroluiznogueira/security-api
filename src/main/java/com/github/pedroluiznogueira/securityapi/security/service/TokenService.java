package com.github.pedroluiznogueira.securityapi.security.service;

import com.github.pedroluiznogueira.securityapi.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

@Service
public class TokenService {

    // env variable
    @Value("${jwt.expiration}")
    private String expiration;

    // env variable
    @Value("${jwt.secret}")
    private String secret;

    // generate a token based on username and password
    public String generateToken(Authentication authentication) {

        User usuario = (User) authentication.getPrincipal();

        Date now = new Date();
        Date exp = new Date(now.getTime() + Long.parseLong(expiration));

        // build jwt
        return Jwts.builder().setIssuer("IRS").setSubject(usuario.getId().toString()).setIssuedAt(new Date())
                .setExpiration(exp).signWith(SignatureAlgorithm.HS256, secret).compact();
    }

}
