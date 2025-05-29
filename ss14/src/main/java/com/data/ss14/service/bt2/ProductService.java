package com.data.ss14.service.bt2;

import com.data.ss14.dao.bt2.ProductDAO;
import com.data.ss14.model.bt2.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductDAO productDAO;

    public void addProduct(Product product) {
        productDAO.save(product);
    }

    public List<Product> getAllProducts() {
        return productDAO.findAll();
    }
}

