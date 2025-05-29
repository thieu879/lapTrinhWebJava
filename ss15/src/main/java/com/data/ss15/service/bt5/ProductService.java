package com.data.ss15.service.bt5;

import com.data.ss15.model.bt5.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private List<Product> products = new ArrayList<>();

    public ProductService() {
        // Thêm dữ liệu mẫu
        products.add(new Product("P001", "Laptop Dell", 1500));
        products.add(new Product("P002", "iPhone 15", 1200));
    }

    public List<Product> searchProducts(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) return Collections.emptyList();

        String searchTerm = keyword.toLowerCase();
        return products.stream()
                .filter(p -> p.getName().toLowerCase().contains(searchTerm) ||
                        p.getId().toLowerCase().contains(searchTerm))
                .collect(Collectors.toList());
    }
}

