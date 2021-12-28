package com.github.pedroluiznogueira.securityapi.controller;

import com.github.pedroluiznogueira.securityapi.dto.TokenDto;
import com.github.pedroluiznogueira.securityapi.dto.UserDto;
import com.github.pedroluiznogueira.securityapi.model.User;
import com.github.pedroluiznogueira.securityapi.repository.UserRepository;
import com.github.pedroluiznogueira.securityapi.security.manager.UserService;
import com.github.pedroluiznogueira.securityapi.security.provider.AuthProvider;
import com.github.pedroluiznogueira.securityapi.security.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register-user")
    public String register(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        boolean loginResponse = userService.login(user);
        if (loginResponse) return "index";
        return "login";
    }

    @PostMapping("/auth")
    public ResponseEntity<TokenDto> auth(@RequestBody UserDto user) {
        // generate a token with user login info to deliver to token service
        UsernamePasswordAuthenticationToken loginCredentials
                = new UsernamePasswordAuthenticationToken(
                        user.getEmail(),
                        user.getPassword()
        );

        // encapsulates all login info token
        Authentication authentication = authenticationManager
                .authenticate(loginCredentials);

        // generate token and set's it in a data transfer object
        String token = tokenService.generateToken(authentication);
        return ResponseEntity.ok(TokenDto.builder().type("Bearer").token(token).build());
    }
}
