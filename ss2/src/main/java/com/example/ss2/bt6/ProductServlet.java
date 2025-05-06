package com.example.ss2.bt6;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "ProductServlet", value = "/ProductServlet")
public class ProductServlet extends HttpServlet {
    private static final List<Product> productList = new ArrayList<>();
    private static int productIdCounter = 1;

    @Override
    public void init() throws ServletException {
        productList.add(new Product(productIdCounter++, "iphone 10", "5000.0"));
        productList.add(new Product(productIdCounter++, "laptop dell", "15000.0"));
        productList.add(new Product(productIdCounter++, "Apple watch 5", "3000.0"));
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("productList", productList);
        request.getRequestDispatcher("/Bt/productList.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        if ("add".equals(action)) {
            String name = request.getParameter("name");
            String price = request.getParameter("price");
            Product newProduct = new Product(productIdCounter++, name, price);
            productList.add(newProduct);
            response.sendRedirect(request.getContextPath() + "/ProductServlet");
        } else if ("delete".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            productList.removeIf(product -> product.getId() == id);
            response.sendRedirect(request.getContextPath() + "/ProductServlet");
        } else if ("edit".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String price = request.getParameter("price");
            for (Product product : productList) {
                if (product.getId() == id) {
                    product.setName(name);
                    product.setPrice(price);
                    break;
                }
            }
            response.sendRedirect(request.getContextPath() + "/ProductServlet");
        } else {
            response.sendRedirect(request.getContextPath() + "/ProductServlet");
        }
    }

    public void destroy() {
    }
}