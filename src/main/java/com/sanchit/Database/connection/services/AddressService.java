package com.sanchit.Database.connection.services;

import com.sanchit.Database.connection.entities.Address;
import com.sanchit.Database.connection.repositories.AddressRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    private AddressRepository addressRepository;
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }
    public void saveAddress (Address address) {
        addressRepository.save(address);
    }
    public Address getAddressById (int id) {
        return addressRepository.findById(id).orElseThrow();
    }
    public void  deleteAddressById (int id) {
        addressRepository.deleteById(id);
    }
}
