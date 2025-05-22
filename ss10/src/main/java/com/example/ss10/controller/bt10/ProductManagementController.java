package com.example.ss10.controller.bt10;

import com.example.ss10.model.bt10.Product;
import com.example.ss10.service.CloudinaryService;
import com.example.ss10.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/products")
public class ProductManagementController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CloudinaryService cloudinaryService;

    @GetMapping
    public String listProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "/bt10/productList";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("product", new Product());
        return "/bt10/productForm";
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute Product product,
                             @RequestParam("imageFile") MultipartFile imageFile,
                             Model model) {
        try {
            if (!imageFile.isEmpty()) {
                String imageUrl = cloudinaryService.uploadFile(imageFile);
                product.setImage(imageUrl);
            }
            productService.addProduct(product);
            return "redirect:/products";
        } catch (IOException e) {
            model.addAttribute("error", "Upload ảnh thất bại: " + e.getMessage());
            return "/bt10/productForm";
        }
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Product product = productService.getProductById(id);
        if (product == null) {
            return "redirect:/products";
        }
        model.addAttribute("product", product);
        return "/bt10/productForm";
    }

    @PostMapping("/edit")
    public String editProduct(@ModelAttribute Product product,
                              @RequestParam("imageFile") MultipartFile imageFile,
                              Model model) {
        try {
            if (!imageFile.isEmpty()) {
                String imageUrl = cloudinaryService.uploadFile(imageFile);
                product.setImage(imageUrl);
            }
            productService.updateProduct(product);
            return "redirect:/products";
        } catch (IOException e) {
            model.addAttribute("error", "Upload ảnh thất bại: " + e.getMessage());
            return "/bt10/productForm";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
        return "redirect:/products";
    }
}

