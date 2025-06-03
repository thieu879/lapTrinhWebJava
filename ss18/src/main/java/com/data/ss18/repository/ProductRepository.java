package com.data.ss18.repository;

import com.data.ss18.entity.Product;
import java.util.List;

public interface ProductRepository {
    List<Product> getAllProduct(int pageNumber, int pageSize);
    void saveProduct(Product product);
    long totalProductCount();
    void updateProduct(Product product);
    Product getProductById(int id);
    List<Product> filterProducts(String keyword, int page, int size);
    long countFilteredProducts(String keyword);
}
