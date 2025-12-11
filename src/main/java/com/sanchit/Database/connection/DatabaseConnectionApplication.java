package com.sanchit.Database.connection;

import com.sanchit.Database.connection.entities.Address;
import com.sanchit.Database.connection.entities.Category;
import com.sanchit.Database.connection.entities.Profile;
import com.sanchit.Database.connection.entities.User;
import com.sanchit.Database.connection.repositories.AddressRepository;
import com.sanchit.Database.connection.repositories.ProfileRepository;
import com.sanchit.Database.connection.repositories.UserRepository;
import com.sanchit.Database.connection.services.*;
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
        var addressService = context.getBean(AddressService.class);
        var profileService = context.getBean(ProfileService.class);
        while(true){
            System.out.println("Option 0: Exit");
            System.out.println("Option 1: Add Category");
            System.out.println("Option 2: Add Product");
            System.out.println("Option 3: Register Yourself");
            System.out.println("Option 4: Add Product to Wishlist");
            System.out.println("Option 5: Delete a product");
            System.out.println("Option 6: Show User Details");
            System.out.println("Option 7: Add Address Details");
            System.out.println("Option 8: Update Profile Details");
            System.out.println("Option 9: Show Profile Above Loyalty Points");
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
                case 6:
                    System.out.print("Enter Your Email: ");
                    String email3 = scan.next();
                    userService.showUserDetails(email3);
                    break;
                case 7:
                    System.out.print("Enter Your Email: ");
                    String email4 = scan.next();
                    System.out.print("Enter Your Password: ");
                    String password4 = scan.next();
                    System.out.print("Enter street: ");
                    String street = scan.next();
                    System.out.print("Enter city: ");
                    String city = scan.next();
                    System.out.print("Enter pincode: ");
                    String pincode = scan.next();
                    addressService.addAddress(email4, street, city, password4, pincode, userService);
                    break;
                case 8:
                    System.out.print("Enter Your Email: ");
                    String email5 = scan.next();
                    System.out.print("Enter Your Password: ");
                    String password5 = scan.next();
                    System.out.print("Enter Your Bio: ");
                    String bio = scan.next();
                    System.out.print("Enter Your Phone Number: ");
                    String phoneNumber = scan.next();
                    System.out.print("Enter DOB In Format YYYYMMDD: ");
                    String dob = scan.next();
                    profileService.updateProfile(email5, password5, bio, phoneNumber, dob, userService);
                    break;
                case 9:
                    System.out.print("Enter Loyalty Points: ");
                    int points = scan.nextInt();
                    profileService.showProfilesAboveLoyaltyPoints(points);
                    break;
            }
        }
	}
}
