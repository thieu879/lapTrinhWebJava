package com.data.ss14.controller.bt2;

import com.data.ss14.model.bt2.Product;
import com.data.ss14.service.bt2.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("product", new Product());
        return "/bt2/add";
    }

    @PostMapping("/add")
    public String handleAdd(@ModelAttribute Product product, HttpSession session) {
        productService.addProduct(product);

        List<Product> list = productService.getAllProducts();
        session.setAttribute("productList", list);

        return "redirect:/product/list";
    }

    @GetMapping("/list")
    public String showList(HttpSession session, Model model) {
        List<Product> list = (List<Product>) session.getAttribute("productList");
        if (list == null) {
            list = productService.getAllProducts(); // fallback nếu session hết hạn
            session.setAttribute("productList", list);
        }

        model.addAttribute("products", list);
        return "/bt2/list";
    }
}

