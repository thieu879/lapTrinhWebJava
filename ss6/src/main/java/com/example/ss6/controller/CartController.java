package com.example.ss6.controller;

import com.example.ss6.model.CartItem;
import com.example.ss6.service.CartService;
import com.example.ss6.service.CartServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CartController", urlPatterns = "/CartController")
public class CartController extends HttpServlet {
    private final CartService cartService;

    public CartController() {
        cartService = new CartServiceImp();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = Integer.parseInt(req.getParameter("userId")); // Assume userId is passed
        List<CartItem> cartItems = cartService.displayCart(userId);
        double total = cartItems.stream().mapToDouble(item -> item.getPrice() * item.getQuantity()).sum();
        req.setAttribute("cartItems", cartItems);
        req.setAttribute("total", total);
        req.getRequestDispatcher("/view/cart.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = Integer.parseInt(req.getParameter("userId"));
        int productId = Integer.parseInt(req.getParameter("productId"));
        cartService.removeFromCart(userId, productId);
        resp.sendRedirect("/CartController?userId=" + userId);
    }
}