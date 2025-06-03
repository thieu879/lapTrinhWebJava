package com.data.ss18.controller;

import com.data.ss18.entity.Customer;
import com.data.ss18.service.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
    public String login(Customer customer, Model model, HttpServletRequest request, HttpServletResponse response) {
        try {
            authService.login(customer.getUsername(), customer.getPassword());
            Customer loggedInCustomer = authService.getCustomerByUsername(customer.getUsername());
            Cookie cookie = new Cookie("customerId", String.valueOf(loggedInCustomer.getId()));
            cookie.setMaxAge(3600);
            response.addCookie(cookie);
            if(loggedInCustomer.isRole()){
                HttpSession session = request.getSession();
                session.setAttribute("admin", loggedInCustomer);
                return "redirect:/user-management";
            }
            return "redirect:/home";
        } catch (Exception e) {
            model.addAttribute("error", "Invalid username or password");
            return "/login";
        }
    }
}
