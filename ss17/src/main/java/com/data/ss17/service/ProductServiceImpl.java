package com.data.ss17.service;

import com.data.ss17.entity.Product;
import com.data.ss17.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts(int page, int size) {
        return productRepository.getAllProducts(page, size); // Không cần -1 ở đây
    }

    @Override
    public long countTotalProducts() {
        return productRepository.countTotalProducts();
    }
    @Override
    public Product getProductById(int id) {
        return productRepository.getProductById(id);
    }
}

