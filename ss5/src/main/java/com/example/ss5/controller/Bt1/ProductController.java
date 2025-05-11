package com.example.ss5.controller.Bt1;

import com.example.ss5.model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "ProductController", value = "/ProductController")
public class ProductController extends HttpServlet {
    private static final List<Product> products = new ArrayList<>();

    public void init() {
        products.add(new Product(1,"Product 1", 10.0, "Description 1"));
        products.add(new Product(2,"Product 2", 20.0, "Description 2"));
        products.add(new Product(3,"Product 3", 30.0, "Description 3"));
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");

        List<Product> listProduct = products;
        request.setAttribute("listProduct", listProduct);
        request.getRequestDispatcher("/view/Bt1/productList.jsp").forward(request, response);
    }

    public void destroy() {
    }
}