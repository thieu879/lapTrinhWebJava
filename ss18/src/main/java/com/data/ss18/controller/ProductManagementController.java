package com.data.ss18.controller;

import com.data.ss18.entity.Product;
import com.data.ss18.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductManagementController {
    @Autowired
    private ProductService productService;

    @GetMapping("/product-management")
    public String productManagement(@RequestParam(value = "search", required = false) String search,
                                    Model model) {
        List<Product> products;
        if (search != null && !search.isEmpty()) {
            products = productService.filterProducts(search, 1, 20);
        } else {
            products = productService.getAllProduct(1, 20);
        }
        model.addAttribute("products", products);
        return "product-management";
    }

    @GetMapping("/add-product")
    public String showAddForm(Model model) {
        model.addAttribute("product", new Product());
        return "add-product";
    }

    @PostMapping("/add-product")
    public String addProduct(@ModelAttribute Product product) {
        productService.saveProduct(product);
        return "redirect:/product-management";
    }

    @GetMapping("/edit-product/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "edit-product";
    }

    @PostMapping("/edit-product")
    public String editProduct(@ModelAttribute Product product) {
        productService.updateProduct(product);
        return "redirect:/product-management";
    }

    @GetMapping("/delete-product/{id}")
    public String deleteProduct(@PathVariable int id) {
        Product product = productService.getProductById(id);
        if (product != null) {
            // Cần bổ sung phương thức xóa trong repository/service
            // productService.deleteProduct(id);
        }
        return "redirect:/product-management";
    }
}
