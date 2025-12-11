package com.sanchit.Database.connection.services;

import com.sanchit.Database.connection.entities.Address;
import com.sanchit.Database.connection.entities.User;
import com.sanchit.Database.connection.repositories.AddressRepository;
import com.sanchit.Database.connection.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    private AddressRepository addressRepository;
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }
    private void saveAddressToUser(User user, Address address) {
        address.setUser(user);
        user.getAddresses().add(address);
    }
    public void addAddress(String email, String street, String city, String password, String pincode, UserService userService) {
        User user = userService.getUserByEmail(email);
        if(user==null){
            System.out.println("User not found");
            return;
        }
        if(!user.getPassword().equals(password)){
            System.out.println("Wrong password");
            return;
        }
        Address address = new Address();
        address.setStreet(street);
        address.setCity(city);
        address.setPincode(pincode);
        saveAddressToUser(user, address);
        addressRepository.save(address);
        System.out.println("Address updated successfully");
    }
    public Address getAddressById (int id) {
        return addressRepository.findById(id).orElseThrow();
    }
    public void  deleteAddressById (int id) {
        addressRepository.deleteById(id);
    }
}
