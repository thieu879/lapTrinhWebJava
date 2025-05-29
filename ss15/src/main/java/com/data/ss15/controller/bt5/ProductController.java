package com.data.ss15.controller.bt5;
import com.data.ss15.model.bt5.Product;
import com.data.ss15.model.bt5.SearchForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ProductController {

    private static final List<Product> PRODUCTS = new ArrayList<>();
    static {
        PRODUCTS.add(new Product("P001", "Laptop Dell", 1500));
        PRODUCTS.add(new Product("P002", "iPhone 15", 1200));
        PRODUCTS.add(new Product("P003", "Samsung Galaxy", 900));
        PRODUCTS.add(new Product("P004", "MacBook Air", 2000));
        PRODUCTS.add(new Product("P005", "Tai nghe Sony", 150));
    }

    @GetMapping("/search")
    public String showSearchForm(Model model) {
        model.addAttribute("searchForm", new SearchForm());
        model.addAttribute("results", null);
        return "/bt5/search-form";
    }

    @PostMapping("/search")
    public String handleSearch(
            @Valid @ModelAttribute("searchForm") SearchForm searchForm,
            BindingResult result,
            Model model) {
        List<Product> results = new ArrayList<>();
        if (!result.hasErrors()) {
            String keyword = searchForm.getKeyword().trim().toLowerCase();
            results = PRODUCTS.stream()
                    .filter(p -> p.getId().toLowerCase().contains(keyword)
                            || p.getName().toLowerCase().contains(keyword))
                    .collect(Collectors.toList());
        }
        model.addAttribute("results", results);
        return "/bt5/search-form";
    }
}



