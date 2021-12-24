package com.github.pedroluiznogueira.securityapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SomeController {

    @GetMapping("some/endpoint")
    public String someRequest() {
        return "Some response";
    }
}
