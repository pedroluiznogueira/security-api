package com.github.pedroluiznogueira.securityapi.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import java.util.Arrays;

public class MyAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        if (username.equals("tom") && password.equals("cruise")) {
            // third parameter as a Collection as one of the authorizations
            return new UsernamePasswordAuthenticationToken(username, password, Arrays.asList());
        } else {
            throw new BadCredentialsException("Invalid username of password");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }
}
