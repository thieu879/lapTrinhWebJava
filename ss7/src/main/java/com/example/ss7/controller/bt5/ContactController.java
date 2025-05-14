package com.example.ss7.controller.bt5;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactController {
    @GetMapping("/contact")
    public String showContact() {
        return "Bai5/contact";
    }
}
