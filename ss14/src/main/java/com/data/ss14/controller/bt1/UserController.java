package com.data.ss14.controller.bt1;

import com.data.ss14.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @GetMapping("/userForm")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "/bt1/userForm";
    }

    @PostMapping("/logIn")
    public String logIn(@ModelAttribute("user") User user, HttpSession session) {
        session.setAttribute("user", user);
        return "redirect:/bt1/welcome";
    }

    @GetMapping("/bt1/welcome")
    public String showWelcomePage(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/userForm";
        }
        model.addAttribute("user", user);
        return "/bt1/welcome";
    }
}

