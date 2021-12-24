package com.github.pedroluiznogueira.securityapi.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import java.util.Arrays;

@Configuration
public class MyAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        if (username.equals("tom") && password.equals("cruise")) {
            // this goes back to manager -> filter -> success handler
            return new UsernamePasswordAuthenticationToken(username, password, Arrays.asList());
        } else {
            // this goes back to manager -> filter -> failure handler
            throw new BadCredentialsException("Invalid username of password");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
