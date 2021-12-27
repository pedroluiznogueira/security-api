package com.github.pedroluiznogueira.securityapi.security.manager;

import com.github.pedroluiznogueira.securityapi.security.provider.AuthProvider;
import com.github.pedroluiznogueira.securityapi.security.filter.AuthFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

// this class has 3 important methods
@Configuration
public class AuthManager extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthProvider authenticationProvider;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // using custom provider component
        auth.authenticationProvider(authenticationProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic();
        http.authorizeRequests().antMatchers("/some/hello").authenticated();
        // best practice
        http.addFilterBefore(new AuthFilter(), BasicAuthenticationFilter.class);
    }
}
