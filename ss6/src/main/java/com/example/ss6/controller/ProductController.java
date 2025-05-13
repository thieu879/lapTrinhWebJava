package com.example.ss6.controller;

import com.example.ss6.model.Product;
import com.example.ss6.service.CartService;
import com.example.ss6.service.CartServiceImp;
import com.example.ss6.service.ProductService;
import com.example.ss6.service.ProductServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductController", urlPatterns = "/ProductController")
public class ProductController extends HttpServlet {
    private final ProductService productService;
    private final CartService cartService;

    public ProductController() {
        productService = new ProductServiceImp();
        cartService = new CartServiceImp();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productService.getAllProducts();
        req.setAttribute("products", products);
        req.getRequestDispatcher("/view/listProduct.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = Integer.parseInt(req.getParameter("userId")); // Assume userId is passed (e.g., from session or form)
        int productId = Integer.parseInt(req.getParameter("productId"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        cartService.addToCart(userId, productId, quantity);
        resp.sendRedirect("/ProductController");
    }
}