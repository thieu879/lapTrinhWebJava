package com.example.ss8.dao.bt2;
import com.example.ss8.model.Product;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class ProductRepository {

    public List<Product> findAll() {
        return Arrays.asList(
                new Product(1, "Laptop", 10, 1200.0),
                new Product(2, "Smartphone", 20, 800.0),
                new Product(3, "Tablet", 15, 400.0)
        );
    }
}

