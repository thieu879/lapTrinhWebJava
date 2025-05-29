package com.data.ss15.service.bt6;

import com.data.ss15.dao.bt6.ProductDAO;
import com.data.ss15.dao.bt6.ProductDAOImpl;
import com.data.ss15.model.bt6.Product;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    private ProductDAO productDAO = new ProductDAOImpl();

    @Override
    public List<Product> getAllProducts() {
        return productDAO.getAllProducts();
    }

    @Override
    public Product getProductById(String id) {
        return productDAO.getProductById(id);
    }

    @Override
    public boolean addProduct(Product product) {
        return productDAO.insertProduct(product);
    }

    @Override
    public boolean updateProduct(Product product) {
        return productDAO.updateProduct(product);
    }

    @Override
    public boolean deleteProduct(String id) {
        return productDAO.deleteProduct(id);
    }
}



