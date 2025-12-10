package com.sanchit.Database.connection.repositories;

import com.sanchit.Database.connection.entities.Tag;
import org.springframework.data.repository.CrudRepository;

public interface TagRepository extends CrudRepository<Tag, Integer> {
}
