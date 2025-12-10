package com.sanchit.Database.connection.repositories;

import com.sanchit.Database.connection.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product,Long> {
}
