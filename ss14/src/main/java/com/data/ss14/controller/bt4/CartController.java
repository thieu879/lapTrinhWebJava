package com.data.ss14.controller.bt4;

import javax.servlet.http.*;

import com.data.ss14.model.bt4.Product;
import com.data.ss14.service.bt4.ProductService;
import com.data.ss14.service.bt4.ProductServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.URLEncoder;
import java.util.*;

@Controller
public class CartController {

    private ProductService productService = new ProductServiceImpl();

    @GetMapping("/form")
    public String form(Model model, HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        String saved = null;
        for (Cookie c : cookies != null ? cookies : new Cookie[0]) {
            if (c.getName().equals("products")) {
                saved = c.getValue();
                break;
            }
        }
        List<Product> cookieProducts = productService.parseCookieData(saved);
        model.addAttribute("cookieProducts", cookieProducts);
        return "/bt4/form";
    }

    @PostMapping("/add")
    public String addToCart(@RequestParam String name, @RequestParam int quantity,
                            HttpSession session, HttpServletResponse response,
                            HttpServletRequest request) {
        Product p = new Product(name, quantity);
        productService.addProduct(p);

        // Lưu vào session
        List<Product> cart = (List<Product>) session.getAttribute("CART");
        if (cart == null)
            cart = new ArrayList<>();
        cart.add(p);
        session.setAttribute("CART", cart);

        // Lưu vào cookie
        StringBuilder cookieValue = new StringBuilder();
        for (Product pr : cart) {
            cookieValue.append(pr.getName()).append(":").append(pr.getQuantity()).append(",");
        }

        Cookie productCookie = new Cookie("products", URLEncoder.encode(cookieValue.toString(), java.nio.charset.StandardCharsets.UTF_8));
        productCookie.setMaxAge(7 * 24 * 60 * 60);
        response.addCookie(productCookie);

        return "redirect:/cart";
    }

    @GetMapping("/cart")
    public String viewCart(HttpSession session, Model model) {
        List<Product> cart = (List<Product>) session.getAttribute("CART");
        model.addAttribute("cart", cart != null ? cart : new ArrayList<>());
        return "/bt4/cart";
    }

    @GetMapping("/remove")
    public String removeItem(@RequestParam("name") String name, HttpSession session) {
        List<Product> cart = (List<Product>) session.getAttribute("CART");
        if (cart != null) {
            cart.removeIf(p -> p.getName().equals(name));
            session.setAttribute("CART", cart);
        }
        return "redirect:/cart";
    }
}

