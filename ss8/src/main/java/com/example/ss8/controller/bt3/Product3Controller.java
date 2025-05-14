package com.example.ss8.controller.bt3;

import com.example.ss8.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Product3Controller {

    @GetMapping("/products/add")
    public String showAddProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "/bt3/addProduct";
    }

    @PostMapping("/products/add")
    public String addProduct(@ModelAttribute("product") Product product, Model model) {
        model.addAttribute("product", product);
        return "/bt3/view";
    }
}

