package com.data.ss17.controller;

import com.data.ss17.entity.Customer;
import com.data.ss17.service.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    private AuthService authService;
    public AuthController(AuthService authService) {
        this.authService = authService;
    }
    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("customer", new Customer());
        return "/register";
    }
    @PostMapping("/register")
    public String register(Customer customer, Model model) {
        authService.register(customer.getUsername(), customer.getPassword(), customer.getEmail(), customer.getPhone());
        return "redirect:/login";
    }
    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("customer", new Customer());
        return "/login";
    }
    @PostMapping("/login")
    public String login(Customer customer, Model model) {
        try {
            authService.login(customer.getUsername(), customer.getPassword());
            return "redirect:/home";
        } catch (Exception e) {
            model.addAttribute("error", "Invalid username or password");
            return "/login";
        }
    }
}
