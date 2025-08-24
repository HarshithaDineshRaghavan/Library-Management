package com.librarymanagement.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/home")
    public String homePage() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("User Authorities: " + auth.getAuthorities());
        return "home";
    }
}