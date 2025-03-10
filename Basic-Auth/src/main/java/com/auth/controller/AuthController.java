package com.auth.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.security.Principal;

@RestController
@RequestMapping("/api")
public class AuthController {

    @GetMapping("/public")
    public String publicEndpoint() {
        return "This is a public endpoint, no authentication required.";
    }

    @GetMapping("/private")
    public String privateEndpoint(Principal principal) {
        return "Hello, " + principal.getName() + "! This is a private endpoint.";
    }
}
