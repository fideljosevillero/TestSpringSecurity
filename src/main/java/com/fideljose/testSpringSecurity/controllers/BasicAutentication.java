package com.fideljose.testSpringSecurity.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/security")
public class BasicAutentication {

    @GetMapping("/basic")
    public String basic
            (){
        return "Autenticado Basic Spring Security!!!";
    }

    //@PreAuthorize("hasRole('USER')")
    @PreAuthorize("hasAuthority('USER')")
    @GetMapping("/user")
    public String userAutentication(){
        return "Hi user!!!";
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/admin")
    public String adminAutentication(){
        return "Hi admin!!!";
    }
}
