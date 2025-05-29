package com.data.ss14.service.bt4;

import com.data.ss14.model.bt4.Product;

import java.util.List;

public interface ProductService {
    void addProduct(Product p);
    List<Product> parseCookieData(String cookieValue);
}

