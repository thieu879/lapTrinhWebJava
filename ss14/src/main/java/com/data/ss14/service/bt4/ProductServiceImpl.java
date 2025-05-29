package com.data.ss14.service.bt4;

import com.data.ss14.dao.bt4.ProductDAO;
import com.data.ss14.dao.bt4.ProductDAOImpl;
import com.data.ss14.model.bt4.Product;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    private ProductDAO productDAO = new ProductDAOImpl();

    @Override
    public void addProduct(Product p) {
        productDAO.saveProduct(p);
    }

    @Override
    public List<Product> parseCookieData(String cookieValue) {
        return productDAO.getProductsFromCookies(cookieValue);
    }
}

