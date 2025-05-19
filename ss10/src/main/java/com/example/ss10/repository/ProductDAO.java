package com.example.ss10.repository;
import com.example.ss10.model.bt10.Product;

import java.util.List;

public interface ProductDAO {
    void insertProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(int id);
    Product getProductById(int id);
    List<Product> getAllProducts();
}


