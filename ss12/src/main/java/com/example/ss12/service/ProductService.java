package com.example.ss12.service;

import com.example.ss12.model.Product;

import java.util.List;

public interface ProductService {
    boolean addProduct(Product product);
    Product getProductById(int id);
    boolean updateProduct(Product product);
    boolean deleteProduct(int id);
    List<Product> getAllProducts();
    List<Product> searchProducts(String productName);
}
