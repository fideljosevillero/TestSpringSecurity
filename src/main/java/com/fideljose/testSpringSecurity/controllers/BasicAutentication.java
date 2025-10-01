package com.fideljose.testSpringSecurity.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/security")
public class BasicAutentication {

    @GetMapping("/basic")
    public String basicAutentication(){
        return "Autenticado Basic Spring Security!!!";
    }
}
