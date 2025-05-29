package com.data.ss15.controller.bt3;

import com.data.ss15.model.bt3.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {
    @GetMapping("/register")
    public String showUserForm(Model model) {
        model.addAttribute("user", new User());
        return "bt3/register";
    }

    @PostMapping("/register")
    public String submitUserForm(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "bt3/register";
        }
        model.addAttribute("user", user);
        return "bt3/result";
    }
}
