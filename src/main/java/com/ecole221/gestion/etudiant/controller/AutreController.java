package com.ecole221.gestion.etudiant.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SecurityRequirement(name = "Authorization")
@RestController
@RequestMapping("/api/autre")
public class AutreController {
    @PreAuthorize("hasAuthority('admin')")
    @GetMapping("/admin")
    public String test (){return "hello autre admin";}

    @PreAuthorize("hasAuthority('user')")
    @GetMapping("/user")
    public String testUser (){return "hello autre user";}

    @PreAuthorize("hasAuthority('user') or hasAuthority('admin')")
    @GetMapping("/user-admin")
    public String testUserAdmin (){return "hello autre user/admin";}
}
