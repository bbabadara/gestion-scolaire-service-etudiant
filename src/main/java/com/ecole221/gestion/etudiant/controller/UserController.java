package com.ecole221.gestion.etudiant.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SecurityRequirement(name = "Authorization")
@RestController
@RequestMapping("/api/user")
public class UserController {
    @GetMapping
    public String test (){return "hello user";}
}
