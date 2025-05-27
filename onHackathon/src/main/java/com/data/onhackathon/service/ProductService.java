package com.data.onhackathon.service;
import com.data.onhackathon.dto.ProductDTO;
import com.data.onhackathon.model.Product;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(int id);
    void add(Product product);
    void update(int id, Product product);
    void delete(int id);
    List<Product> search(String keyword);
}
