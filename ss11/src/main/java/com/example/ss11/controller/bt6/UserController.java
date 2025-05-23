package com.example.ss11.controller.bt6;

import com.example.ss11.dto.UserForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;

@Controller
public class UserController {

    @GetMapping("/registers")
    public String showForm(Model model) {
        model.addAttribute("userForm", new UserForm());
        return "/bt6/registers";
    }

    @PostMapping("/registers")
    public String submitForm(
            @Valid @ModelAttribute("userForm") UserForm userForm,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "/bt6/registers";
        }
        return "/bt6/success";
    }
}

