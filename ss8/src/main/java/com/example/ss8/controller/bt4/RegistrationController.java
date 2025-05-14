package com.example.ss8.controller.bt4;

import com.example.ss8.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class RegistrationController {

    @GetMapping("/register")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("errors", new HashMap<String, String>());
        return "/bt4/registration";
    }

    @PostMapping("/register")
    public String submitForm(@ModelAttribute("user") User user, Model model) {
        Map<String, String> errors = new HashMap<>();

        if (user.getName() == null || user.getName().trim().isEmpty()) {
            errors.put("name", "Tên không được để trống");
        }

        if (user.getEmail() == null || !user.getEmail().matches("^.+@.+\\..+$")) {
            errors.put("email", "Email không hợp lệ");
        }

        if (user.getPhone() == null || !user.getPhone().matches("\\d{10}")) {
            errors.put("phone", "Số điện thoại phải gồm 10 chữ số");
        }

        if (!errors.isEmpty()) {
            model.addAttribute("errors", errors);
            return "/bt4/registration";
        }

        model.addAttribute("user", user);
        return "/bt4/result";
    }
}


