package com.github.pedroluiznogueira.securityapi.security;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Component
public class MyAuthenticationFilter implements Filter {

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain
    ) throws IOException, ServletException {
        // before logic doFilter() happens when the request goes in
        System.out.println("Before...");

        chain.doFilter(request, response);

        // after logic doFilter() happens when the request comes back
        System.out.println("After...");
    }
}
