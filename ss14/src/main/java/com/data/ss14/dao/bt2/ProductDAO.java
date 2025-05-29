package com.data.ss14.dao.bt2;

import com.data.ss14.model.bt2.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDAO {
    private List<Product> db = new ArrayList<>();

    public void save(Product product) {
        db.add(product);
    }

    public List<Product> findAll() {
        return new ArrayList<>(db);
    }
}
