package com.example.ss7.controller.bt8;
import com.example.ss7.model.Products;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ProductController {

    @RequestMapping("/product/{category}")
    public String getProductsByCategory(
            @PathVariable String category,
            @MatrixVariable(pathVar = "category", value = "color", required = false) String color,
            @MatrixVariable(pathVar = "category", value = "size", required = false) String size,
            Model model) {

        List<Products> products = new ArrayList<>();

        products.add(new Products("Pants", "black", "M"));
        products.add(new Products("Pants", "blue", "L"));
        products.add(new Products("Pants", "green", "XL"));
        products.add(new Products("Pants", "white", "S"));
        products.add(new Products("Pants", "pink", "M"));


        List<Products> filtered = products.stream()
                .filter(p -> (color == null || p.getColor().equalsIgnoreCase(color)))
                .filter(p -> (size == null || p.getSize().equalsIgnoreCase(size)))
                .collect(Collectors.toList());

        model.addAttribute("products", filtered);
        model.addAttribute("category", category);
        model.addAttribute("color", color);
        model.addAttribute("size", size);

        return "Bai8/product";
    }
}
