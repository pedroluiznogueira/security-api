package com.github.pedroluiznogueira.securityapi.controller;

import com.github.pedroluiznogueira.securityapi.model.User;
import com.github.pedroluiznogueira.securityapi.repository.UserRepository;
import com.github.pedroluiznogueira.securityapi.security.manager.UserService;
import com.github.pedroluiznogueira.securityapi.security.provider.AuthProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

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
    public void auth() {
    }
}
