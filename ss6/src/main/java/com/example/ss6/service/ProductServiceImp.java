package com.example.ss6.service;

import com.example.ss6.dao.product.ProductDao;
import com.example.ss6.dao.product.ProductDaoImp;
import com.example.ss6.model.Product;

import java.util.List;

public class ProductServiceImp implements ProductService {
    private final ProductDao productDao;

    public ProductServiceImp() {
        productDao = new ProductDaoImp();
    }

    @Override
    public List<Product> getAllProducts() {
        return productDao.getAllProducts();
    }
}