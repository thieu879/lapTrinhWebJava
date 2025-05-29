package com.data.ss15.controller.bt6;

import com.data.ss15.model.bt6.Product;
import com.data.ss15.service.bt6.ProductService;
import com.data.ss15.service.bt6.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/products")
public class ProductController extends HttpServlet {
    private ProductService productService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) action = "list";

        switch (action) {
            case "add":
                req.getRequestDispatcher("/bt6/product-form.jsp").forward(req, resp);
                break;
            case "edit":
                String id = req.getParameter("id");
                Product product = productService.getProductById(id);
                req.setAttribute("product", product);
                req.getRequestDispatcher("/bt6/product-form.jsp").forward(req, resp);
                break;
            case "delete":
                id = req.getParameter("id");
                productService.deleteProduct(id);
                resp.sendRedirect("products");
                break;
            default:
                List<Product> list = productService.getAllProducts();
                req.setAttribute("products", list);
                req.getRequestDispatcher("/bt6/product-list.jsp").forward(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("idProduct");
        String name = req.getParameter("productName");
        double price = Double.parseDouble(req.getParameter("price"));
        String category = req.getParameter("category");
        String image = req.getParameter("image");

        Product p = new Product(id, name, price, category, image);

        String action = req.getParameter("action");
        if ("edit".equals(action)) {
            productService.updateProduct(p);
        } else {
            productService.addProduct(p);
        }
        resp.sendRedirect("products");
    }
}



