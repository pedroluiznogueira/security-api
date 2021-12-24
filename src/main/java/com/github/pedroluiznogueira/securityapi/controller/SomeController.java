package com.github.pedroluiznogueira.securityapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("some")
public class SomeController {

    @GetMapping
    public String defoult() {
        return "default";
    }

    @GetMapping("hello")
    public String hello() {
        return "hello";
    }
}
