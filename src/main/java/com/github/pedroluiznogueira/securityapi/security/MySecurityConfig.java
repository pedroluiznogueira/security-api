package com.github.pedroluiznogueira.securityapi.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

// this class has 3 important methods
@Configuration
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    // customizing AuthenticationManager component
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    }
}
