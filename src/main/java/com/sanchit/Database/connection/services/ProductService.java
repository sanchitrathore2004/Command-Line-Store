package com.sanchit.Database.connection.services;

import com.sanchit.Database.connection.entities.Category;
import com.sanchit.Database.connection.entities.Product;
import com.sanchit.Database.connection.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProductService {
    private ProductRepository productRepository;
    private void addProductToCategory (Product product, Category category) {
        product.setCategory(category);
        category.getProducts().add(product);
    }
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Transactional
    public void addProduct (String productName, double productPrice, String categoryName, CategoryService categoryService) {
        Product product = new Product();
        product.setName(productName);
        product.setPrice(BigDecimal.valueOf(productPrice));
        Category category = categoryService.findCategoryByName(categoryName);
        if(category == null) {
            System.out.println("Category not found");
            return ;
        }
        addProductToCategory(product, category);
        productRepository.save(product);
        System.out.println("Product added successfully");
    }
    public Product findProductByName(String productName) {
        for(Product product : productRepository.findAll()) {
            if(product.getName().equals(productName)) {
                return product;
            }
        }
        return null;
    }
    public void deleteProductByName(String productName) {
        Product product = findProductByName(productName);
        productRepository.delete(product);
        System.out.println("Product deleted successfully");
    }
}
