package com.example.ss4.bt4;

import com.example.ss4.bt1.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "ProductsServlet", value = "/ProductsServlet")
public class ProductsServlet extends HttpServlet {
    List<Product> products = new ArrayList<>();
    public void init() {
        products.add(new Product("Description 1", 1, "1000", "Product 1"));
        products.add(new Product("Description 2", 2, "2000", "Product 2"));
        products.add(new Product("Description 3", 3, "3000", "Product 3"));
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");

        String search = request.getParameter("search");
        List<Product> filteredProducts;

        if (search != null && !search.trim().isEmpty()) {
            filteredProducts = new ArrayList<>();
            for (Product p : products) {
                if (p.getProductName().toLowerCase().contains(search.toLowerCase())) {
                    filteredProducts.add(p);
                }
            }
        } else {
            filteredProducts = products;
        }

        request.setAttribute("products", filteredProducts);
        request.setAttribute("hasResults", !filteredProducts.isEmpty());
        request.getRequestDispatcher("/bt/bt5/searchProduct.jsp").forward(request, response);
    }

    public void destroy() {
    }
}