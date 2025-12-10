package com.sanchit.Database.connection.repositories;

import com.sanchit.Database.connection.entities.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Integer> {
}
