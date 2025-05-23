package com.example.ss11.service.bt8;

import com.example.ss11.model.bt8.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    Category getCategoryById(Long id);
    boolean addCategory(Category category);
    boolean updateCategory(Category category);
    boolean deleteCategory(Long id);
    boolean existsByCategoryName(String categoryName);
    boolean existsByCategoryNameAndNotId(String categoryName, Long id);
}
