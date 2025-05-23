package com.example.ss11.service.bt8;

import com.example.ss11.dao.bt8.CategoryDAO;
import com.example.ss11.dao.bt8.CategoryDAOImpl;
import com.example.ss11.model.bt8.Category;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    private final CategoryDAO categoryDAO = new CategoryDAOImpl();

    @Override
    public List<Category> getAllCategories() {
        return categoryDAO.getAllCategories();
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryDAO.getCategoryById(id);
    }

    @Override
    public boolean addCategory(Category category) {
        return categoryDAO.addCategory(category);
    }

    @Override
    public boolean updateCategory(Category category) {
        return categoryDAO.updateCategory(category);
    }

    @Override
    public boolean deleteCategory(Long id) {
        return categoryDAO.deleteCategory(id);
    }

    @Override
    public boolean existsByCategoryName(String categoryName) {
        return categoryDAO.existsByCategoryName(categoryName);
    }

    @Override
    public boolean existsByCategoryNameAndNotId(String categoryName, Long id) {
        return categoryDAO.existsByCategoryNameAndNotId(categoryName, id);
    }
}
