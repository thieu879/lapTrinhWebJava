package com.example.ss3.bt10;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CartServlet", value = "/CartServlet")
public class CartServlet extends HttpServlet {
    private CartManager cartManager;

    public void init() throws ServletException {
        cartManager = new CartManager();
        getServletContext().setAttribute("cartManager", cartManager);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if ("remove".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            cartManager.removeProduct(id);
        }
        response.sendRedirect("/Bt/Bt10/cart.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if ("add".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            double price = Double.parseDouble(request.getParameter("price"));

            Product product = new Product(id, name, price);
            boolean added = cartManager.addProduct(product);

            if (added) {
                request.setAttribute("message", "Thêm sản phẩm vào giỏ hàng thành công!");
            } else {
                request.setAttribute("message", "Sản phẩm đã tồn tại trong giỏ hàng!");
            }
        }
        request.getRequestDispatcher("/Bt/Bt10/products.jsp").forward(request, response);
    }
}