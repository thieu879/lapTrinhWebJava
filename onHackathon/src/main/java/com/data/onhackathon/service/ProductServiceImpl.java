package com.data.onhackathon.service;
import com.data.onhackathon.dao.ProductRepository;
import com.data.onhackathon.dto.ProductDTO;
import com.data.onhackathon.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    private final String uploadDir = "webapp/uploads/";

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    private String handleUpload(MultipartFile file) {
        if (file == null || file.isEmpty()) return null;
        String filename = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        try {
            File dest = new File(uploadDir + filename);
            file.transferTo(dest);
            return filename;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void add(Product product) {
        productRepository.add(product);
    }

    @Override
    public void update(int id, Product product) {
        productRepository.update(product);
    }


    @Override
    public void delete(int id) {
        productRepository.delete(id);
    }

    @Override
    public List<Product> search(String keyword) {
        return productRepository.search(keyword);
    }
}
