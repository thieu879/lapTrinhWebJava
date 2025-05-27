package com.data.onhackathon.controller;
import com.data.onhackathon.dto.ProductDTO;
import com.data.onhackathon.model.Product;
import com.data.onhackathon.service.CloudinaryService;
import com.data.onhackathon.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CloudinaryService cloudinaryService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("products", productService.findAll());
        return "list";
    }

    @GetMapping("/add")
    public String showAdd(Model model) {
        model.addAttribute("product", new ProductDTO());
        return "add";
    }

    @PostMapping("/add")
    public String doAdd(
            @ModelAttribute("product") Product product,
            BindingResult result,
            @RequestParam(value = "imageFile", required = false) MultipartFile imageFile,
            Model model
    ) {
        // Validate các trường cơ bản
        if (product.getProductName() == null || product.getProductName().trim().isEmpty()) {
            result.rejectValue("productName", "error.productName", "Tên sản phẩm không để trống");
        }
        if (product.getStatus() == null || product.getStatus().toString().trim().isEmpty()) {
            result.rejectValue("status", "error.status", "Trạng thái không được để trống");
        }
        if (result.hasErrors()) {
            model.addAttribute("product", product);
            return "add";
        }
        // Kiểm tra file ảnh
        if (imageFile == null || imageFile.isEmpty()) {
            model.addAttribute("error", "Vui lòng chọn ảnh sản phẩm.");
            model.addAttribute("product", product);
            return "add";
        }
        try {
            // Upload ảnh lên Cloudinary
            String imageUrl = cloudinaryService.uploadImage(imageFile);
            if (imageUrl == null) {
                model.addAttribute("error", "Không upload được ảnh sản phẩm.");
                model.addAttribute("product", product);
                return "add";
            }
            product.setImage(imageUrl); // Gán link ảnh vào trường image
            product.setCreatedAt(java.time.LocalDateTime.now());
            productService.add(product);
            return "redirect:/products";
        } catch (IOException e) {
            model.addAttribute("error", "Lỗi upload ảnh: " + e.getMessage());
            model.addAttribute("product", product);
            return "add";
        }
    }


    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable int id, Model model) {
        Product product = productService.findById(id);
        if (product == null) {
            return "redirect:/products"; // Hoặc báo lỗi
        }
        model.addAttribute("product", product);
        model.addAttribute("id", id);
        return "edit";
    }

    @PostMapping("/edit/{id}")
    public String doEdit(
            @PathVariable int id,
            @ModelAttribute("product") Product product,
            BindingResult result,
            @RequestParam(value = "imageFile", required = false) MultipartFile imageFile,
            Model model
    ) {
        if (product.getProductName() == null || product.getProductName().trim().isEmpty()) {
            result.rejectValue("productName", "error.productName", "Tên sản phẩm không để trống");
        }
        if (product.getStatus() == null || product.getStatus().toString().trim().isEmpty()) {
            result.rejectValue("status", "error.status", "Trạng thái không được để trống");
        }
        if (result.hasErrors()) {
            model.addAttribute("id", id);
            return "edit";
        }

        try {
            Product old = productService.findById(id);
            if (imageFile != null && !imageFile.isEmpty()) {
                String imageUrl = cloudinaryService.uploadImage(imageFile);
                if (imageUrl == null) {
                    model.addAttribute("error", "Không upload được ảnh sản phẩm.");
                    model.addAttribute("id", id);
                    return "edit";
                }
                product.setImage(imageUrl);
            } else {
                product.setImage(old.getImage());
            }

            product.setId(id);
            product.setCreatedAt(old.getCreatedAt());

            productService.update(id, product);
            return "redirect:/products";
        } catch (IOException e) {
            model.addAttribute("error", "Lỗi upload ảnh: " + e.getMessage());
            model.addAttribute("id", id);
            return "edit";
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        productService.delete(id);
        return "redirect:/products";
    }

    @GetMapping("/search")
    public String search(@RequestParam("keyword") String key, Model model) {
        List<Product> rs = productService.search(key);
        model.addAttribute("products", rs);
        return "list";
    }
}