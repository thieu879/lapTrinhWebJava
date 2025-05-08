package com.example.ss4.bt4;

import com.example.ss4.bt1.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "ProductServlets", value = "/ProductServlets")
public class ProductServlets extends HttpServlet {
    List<Product> products = new ArrayList<>();
    public void init() {
//        products.add(new Product("Description 1", 1, "1000", "Product 1"));
//        products.add(new Product("Description 2", 2, "2000", "Product 2"));
//        products.add(new Product("Description 3", 3, "3000", "Product 3"));
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        request.setAttribute("products", products);

        request.getRequestDispatcher("/bt/bt4/products.jsp").forward(request, response);
    }

    public void destroy() {
    }
}