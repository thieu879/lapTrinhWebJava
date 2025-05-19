package com.example.ss10.service;
import com.example.ss10.model.bt10.Product;
import com.example.ss10.repository.ProductDAO;
import com.example.ss10.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service  // quan trọng, Spring sẽ tạo bean service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDAO productDAO;  // Spring sẽ inject ProductDAOImpl

    @Override
    public void addProduct(Product product) {
        productDAO.insertProduct(product);
    }

    @Override
    public void updateProduct(Product product) {
        productDAO.updateProduct(product);
    }

    @Override
    public void deleteProduct(int id) {
        productDAO.deleteProduct(id);
    }

    @Override
    public Product getProductById(int id) {
        return productDAO.getProductById(id);
    }

    @Override
    public List<Product> getAllProducts() {
        return productDAO.getAllProducts();
    }
}


