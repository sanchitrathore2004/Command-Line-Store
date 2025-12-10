package com.sanchit.Database.connection.services;

import com.sanchit.Database.connection.entities.Category;
import com.sanchit.Database.connection.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    public void addCategory(String categoryName) {
        var category = new Category();
        category.setName(categoryName);
        categoryRepository.save(category);
        System.out.println("Category added successfully");
    }
    public Category findCategoryByName(String categoryName) {
        for (Category category : categoryRepository.findAll()) {
            if (category.getName().equals(categoryName)) {
                return category;
            }
        }
        return null;
    }
}
