package com.example.ss7.controller.bt5;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("/index")
    public String showIndex() {
        return "Bai5/index";
    }
}
