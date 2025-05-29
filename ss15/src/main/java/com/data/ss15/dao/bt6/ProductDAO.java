package com.data.ss15.dao.bt6;

import com.data.ss15.model.bt6.Product;

import java.util.List;

public interface ProductDAO {
    List<Product> getAllProducts();
    Product getProductById(String id);
    boolean insertProduct(Product product);
    boolean updateProduct(Product product);
    boolean deleteProduct(String id);
}

