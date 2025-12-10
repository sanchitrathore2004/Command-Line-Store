package com.sanchit.Database.connection.repositories;

import com.sanchit.Database.connection.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category,Byte> {
}
