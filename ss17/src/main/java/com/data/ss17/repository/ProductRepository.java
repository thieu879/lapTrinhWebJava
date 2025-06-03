package com.data.ss17.repository;

import com.data.ss17.entity.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> getAllProducts(int page, int size);
    long countTotalProducts();
    Product getProductById(int id);
}
