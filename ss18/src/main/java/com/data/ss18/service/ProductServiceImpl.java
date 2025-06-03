package com.data.ss18.service;

import com.data.ss18.entity.Product;
import com.data.ss18.repository.ProductRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    public long countFilteredProducts(String keyword) {
        return productRepository.countFilteredProducts(keyword);
    }

    @Override
    public List<Product> getAllProduct(int pageNumber, int pageSize) {
        return productRepository.getAllProduct(pageNumber, pageSize);
    }

    @Override
    public void saveProduct(Product product) {
        productRepository.saveProduct(product);
    }

    @Override
    public long totalProductCount() {
        return productRepository.totalProductCount();
    }

    @Override
    public void updateProduct(Product product) {
        productRepository.updateProduct(product);
    }

    @Override
    public Product getProductById(int id) {
        return productRepository.getProductById(id);
    }

    @Override
    public List<Product> filterProducts(String keyword, int page, int size) {
        return productRepository.filterProducts(keyword, page, size);
    }
}
