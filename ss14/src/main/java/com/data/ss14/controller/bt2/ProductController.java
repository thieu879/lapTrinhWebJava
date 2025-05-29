package com.data.ss14.controller.bt2;

import com.data.ss14.model.bt2.Product;
import com.data.ss14.service.bt2.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("product", new Product());
        return "bt2/add";  // chú ý: không có / đầu tiên
    }

    @PostMapping("/add")
    public String handleAdd(@Valid @ModelAttribute("product") Product product, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "bt2/add"; // trả lại form nếu lỗi validate
        }

        productService.addProduct(product);
        return "redirect:/product/list";  // redirect sau khi thêm thành công
    }

    @GetMapping({"/list", ""}) // map cả /product và /product/list
    public String showList(Model model) {
        List<Product> list = productService.getAllProducts();
        model.addAttribute("products", list);
        return "bt2/list";
    }
}
