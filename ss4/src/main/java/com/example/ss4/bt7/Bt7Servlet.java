package com.example.ss4.bt7;

import com.example.ss4.bt1.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "Bt7Servlet", value = "/Bt7Servlet")
public class Bt7Servlet extends HttpServlet {
    List<Product> products = new ArrayList<>();

    public void init() {
        products.add(new Product("Description 1", 1, "1000", "Product 1"));
        products.add(new Product("Description 2", 2, "2000", "Product 2"));
        products.add(new Product("Description 3", 3, "3000", "Product 3"));
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");

        String search = request.getParameter("search");
        String minPriceStr = request.getParameter("minPrice");
        String maxPriceStr = request.getParameter("maxPrice");

        double minPrice = 0;
        double maxPrice = Double.MAX_VALUE;

        try {
            if (minPriceStr != null && !minPriceStr.isEmpty()) {
                minPrice = Double.parseDouble(minPriceStr);
            }
            if (maxPriceStr != null && !maxPriceStr.isEmpty()) {
                maxPrice = Double.parseDouble(maxPriceStr);
            }
        } catch (NumberFormatException e) {
            // Không xử lý, dùng giá trị mặc định
        }

        List<Product> filteredProducts = new ArrayList<>();

        for (Product p : products) {
            double price = Double.parseDouble(p.getPrice());
            boolean matchesSearch = (search == null || search.trim().isEmpty())
                    || p.getProductName().toLowerCase().contains(search.toLowerCase());
            boolean inPriceRange = price >= minPrice && price <= maxPrice;

            if (matchesSearch && inPriceRange) {
                filteredProducts.add(p);
            }
        }

        request.setAttribute("products", filteredProducts);
        request.setAttribute("hasResults", !filteredProducts.isEmpty());
        request.getRequestDispatcher("/bt/bt7/bt7.jsp").forward(request, response);
    }

    public void destroy() {
    }
}
