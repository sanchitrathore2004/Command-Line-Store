package com.sanchit.Database.connection.repositories;

import com.sanchit.Database.connection.entities.Profile;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProfileRepository extends CrudRepository<Profile,Integer> {
    @EntityGraph(attributePaths = "user")
    @Query(value = "SELECT p FROM Profile p WHERE p.loyaltyPoints > :minLoyaltyPoints order by p.user.email")
    List<Profile> getProfileAboveLoyaltyPoints(int minLoyaltyPoints);
}
