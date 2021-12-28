package com.github.pedroluiznogueira.securityapi.security.filter;

import com.github.pedroluiznogueira.securityapi.repository.UserRepository;
import com.github.pedroluiznogueira.securityapi.security.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

public class TokenFilter extends OncePerRequestFilter {

    // accessing request's header
    private String getTokenFromHeader(HttpServletRequest request) {

        // it comes as "Authorization: Bearer token..."
        String token = request.getHeader("Authorization");

        if(token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
            return null;
        }
        return token.substring(7, token.length());
    }
}
