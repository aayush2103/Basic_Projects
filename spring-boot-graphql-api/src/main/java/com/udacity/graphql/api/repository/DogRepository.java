package com.udacity.graphql.api.repository;

import com.udacity.graphql.api.entity.Dog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DogRepository extends CrudRepository<Dog, Long> {
    @Query("SELECT d FROM Dog d WHERE d.breed=:breed")
    List<Dog> findDogsByBreed(String breed);
}
