package com.github.pedroluiznogueira.securityapi.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

// this class has 3 important methods
@Configuration
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    // customizing AuthenticationManager component
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // authentication provider component

        // password enconder
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        // UserDetailsService
        InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();

        // wich user to UserDetailsService to use
        UserDetails user = User
                .withUsername("tom")
                .password(passwordEncoder.encode("cruise"))
                .build();
        userDetailsService.createUser(user);

        // telling UserDetailsService about password encoder
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    // wich type of security
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic();
        http.authorizeRequests().anyRequest().authenticated();
    }
}
