package com.sanchit.Database.connection.repositories;

import com.sanchit.Database.connection.entities.Profile;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Profile,Integer> {
}
