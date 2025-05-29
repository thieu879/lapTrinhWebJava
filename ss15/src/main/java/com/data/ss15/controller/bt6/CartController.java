package com.data.ss15.controller.bt6;

import com.data.ss15.model.bt6.Cart;
import com.data.ss15.service.bt6.CartService;
import com.data.ss15.service.bt6.CartServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/carts")
public class CartController extends HttpServlet {
    private CartService cartService = new CartServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) action = "list";

        switch (action) {
            case "add":
                req.getRequestDispatcher("/bt6/cart-form.jsp").forward(req, resp);
                break;
            case "edit":
                String id = req.getParameter("id");
                Cart cart = cartService.getCartById(id);
                req.setAttribute("cart", cart);
                req.getRequestDispatcher("/bt6/cart-form.jsp").forward(req, resp);
                break;
            case "delete":
                id = req.getParameter("id");
                cartService.deleteCart(id);
                resp.sendRedirect("carts");
                break;
            default:
                List<Cart> list = cartService.getAllCarts();
                req.setAttribute("carts", list);
                req.getRequestDispatcher("/bt6/cart-list.jsp").forward(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("idCart");
        String idUser = req.getParameter("idUser");
        String idProduct = req.getParameter("idProduct");
        int quantity = Integer.parseInt(req.getParameter("quantity"));

        Cart cart = new Cart(id, idUser, idProduct, quantity);

        String action = req.getParameter("action");
        if ("edit".equals(action)) {
            cartService.updateCart(cart);
        } else {
            cartService.addCart(cart);
        }
        resp.sendRedirect("carts");
    }
}

