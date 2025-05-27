package com.data.onhackathon.dao;
import com.data.onhackathon.model.Product;

import java.util.List;

public interface ProductRepository {
    void add(Product product);
    void update(Product product);
    void delete(int id);
    Product findById(int id);
    List<Product> findAll();
    List<Product> search(String keyword);
}
