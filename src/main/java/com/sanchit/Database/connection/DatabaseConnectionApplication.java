package com.sanchit.Database.connection;

import com.sanchit.Database.connection.entities.Address;
import com.sanchit.Database.connection.entities.Category;
import com.sanchit.Database.connection.entities.Profile;
import com.sanchit.Database.connection.entities.User;
import com.sanchit.Database.connection.repositories.AddressRepository;
import com.sanchit.Database.connection.repositories.ProfileRepository;
import com.sanchit.Database.connection.repositories.UserRepository;
import com.sanchit.Database.connection.services.AddressService;
import com.sanchit.Database.connection.services.CategoryService;
import com.sanchit.Database.connection.services.ProductService;
import com.sanchit.Database.connection.services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Scanner;

@SpringBootApplication
public class DatabaseConnectionApplication {
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        var context = SpringApplication.run(DatabaseConnectionApplication.class, args);
        var categoryService = context.getBean(CategoryService.class);
        var productService = context.getBean(ProductService.class);
        var userService = context.getBean(UserService.class);
        while(true){
            System.out.println("Option 0: Exit");
            System.out.println("Option 1: Add Category");
            System.out.println("Option 2: Add Product");
            System.out.println("Option 3: Register Yourself");
            System.out.println("Option 4: Add Product to Wishlist");
            System.out.println("Option 5: Delete a product");
            int option = scan.nextInt();
            switch (option) {
                case 0:
                    return ;
                case 1:
                    System.out.print("Enter Category Name: ");
                    String categoryName = scan.next();
                    categoryService.addCategory(categoryName);
                    break;
                case 2:
                    System.out.print("Enter Product Name: ");
                    String productName = scan.next();
                    System.out.print("Enter Product Price: ");
                    double productPrice = scan.nextDouble();
                    System.out.print("Enter category Name: ");
                    String category = scan.next();
                    productService.addProduct(productName, productPrice, category, categoryService);
                    break;
                case 3:
                    System.out.print("Enter Your Name: ");
                    String name = scan.next();
                    System.out.print("Enter Your Email: ");
                    String email = scan.next();
                    System.out.print("Enter Your Password: ");
                    String password = scan.next();
                    userService.registerUser(name, email, password);
                    break;
                case 4:
                    System.out.print("Enter Your Email: ");
                    String email2 = scan.next();
                    System.out.print("Enter Your Password: ");
                    String password2 = scan.next();
                    System.out.print("Enter Product Name: ");
                    String productName2 = scan.next();
                    userService.addProductToWishlist(email2, password2, productName2, productService);
                    break;
                case 5:
                    System.out.print("Enter Product Name: ");
                    String productName3 = scan.next();
                    productService.deleteProductByName(productName3);
            }
        }
	}
}
