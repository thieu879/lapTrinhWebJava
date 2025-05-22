package com.example.ss11.controller.bt1;

import com.example.ss11.model.bt1.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserInforController {
    @GetMapping("/register")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "/bt1/userRegister";
    }
    @PostMapping("/register")
    public String submitForm(@Valid @ModelAttribute("user") User user,
                             BindingResult bindingResult,
                             Model model) {
        if (bindingResult.hasErrors()) {
            return "/bt1/userRegister";
        }
        model.addAttribute("user", user);
        return "/bt1/userSuccess";
    }
}
