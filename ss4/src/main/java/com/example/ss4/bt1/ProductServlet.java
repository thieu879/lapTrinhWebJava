package com.example.ss4.bt1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "ProductServlet", value = "/ProductServlet")
public class ProductServlet extends HttpServlet {
    List<Product> products = new ArrayList<>();
    public void init() {
        products.add(new Product("Description 1", 1, "1000", "Product 1"));
        products.add(new Product("Description 2", 2, "2000", "Product 2"));
        products.add(new Product("Description 3", 3, "3000", "Product 3"));
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        request.setAttribute("productList", products);

        request.getRequestDispatcher("/bt/bt1/productList.jsp").forward(request, response);
    }

    public void destroy() {
    }
}