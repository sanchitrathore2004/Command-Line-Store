package com.sanchit.Database.connection.repositories;

import com.sanchit.Database.connection.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {
}
