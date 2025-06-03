package com.data.ss17.service;

import com.data.ss17.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts(int page, int size);
    long countTotalProducts();
    Product getProductById(int id);
}
