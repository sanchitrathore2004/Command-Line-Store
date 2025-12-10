package com.sanchit.Database.connection.services;

import com.sanchit.Database.connection.entities.Product;
import com.sanchit.Database.connection.entities.User;
import com.sanchit.Database.connection.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    private User findUserByEmail (String email) {
        for(User user: userRepository.findAll()){
            if(user.getEmail().equals(email)){
                return user;
            }
        }
        return null;
    }
    private void addUserToProductWishlist (User user, Product product) {
        user.getWishlist().add(product);
        product.getWishlistUsers().add(user);
    }
    public void registerUser (String name, String email, String password) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        userRepository.save(user);
        System.out.println("User registered successfully");
    }
    @Transactional
    public void addProductToWishlist (String email, String password, String productName, ProductService productService) {
        User user = findUserByEmail(email);
        if(user == null) {
            System.out.println("User not found");
            return ;
        }
        if(!user.getPassword().equals(password)) {
            System.out.println("Wrong password");
            return ;
        }
        Product product = productService.findProductByName(productName);
        if(product == null) {
            System.out.println("Product not found");
            return ;
        }
        addUserToProductWishlist(user, product);
        System.out.println("Product added successfully");
    }
}
