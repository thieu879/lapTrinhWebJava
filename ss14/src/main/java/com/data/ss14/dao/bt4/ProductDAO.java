package com.data.ss14.dao.bt4;
import com.data.ss14.model.bt4.Product;

import java.util.List;

public interface ProductDAO {
    void saveProduct(Product p);
    List<Product> getProductsFromCookies(String cookieValue);
}

