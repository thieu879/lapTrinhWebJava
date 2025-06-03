package com.data.ss17.controller;

import com.data.ss17.entity.Product;
import com.data.ss17.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {
    private final ProductService productService;
    private static final int DEFAULT_PAGE = 1;
    private static final int DEFAULT_SIZE = 5;

    public HomeController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/home")
    public String home(
            Model model,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        // Validate parameters
        page = Math.max(DEFAULT_PAGE, page);
        size = Math.max(1, size);

        long totalProducts = productService.countTotalProducts();
        int totalPages = (int) Math.ceil((double) totalProducts / size);

        // Ensure page doesn't exceed total pages
        page = Math.min(page, totalPages);

        List<Product> products = productService.getAllProducts(page, size);

        model.addAttribute("products", products);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("pageSize", size);

        return "home";
    }

    @GetMapping("/detailProduct")
    public String productDetail(
            @RequestParam("id") int productId,
            Model model
    ) {
        Product product = productService.getProductById(productId);
        model.addAttribute("product", product);
        return "product-details";
    }
}

