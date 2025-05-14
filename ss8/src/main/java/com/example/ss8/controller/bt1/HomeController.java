package com.example.ss8.controller.bt1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String showWelcomePage() {
        return "welcome";
    }
}
