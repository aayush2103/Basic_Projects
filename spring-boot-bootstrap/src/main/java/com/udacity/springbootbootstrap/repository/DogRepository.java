package com.udacity.springbootbootstrap.repository;

import com.udacity.springbootbootstrap.entity.Dog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DogRepository extends CrudRepository<Dog, Long> {

    @Query("SELECT d.id, d.breed FROM Dog d")
    List<String> findAllBreeds();

    @Query("SELECT d.breed FROM Dog d where d.id=:id")
    String findBreedById(Long id);

    @Query("SELECT d.name FROM Dog d")
    List<String> findDogNames();
}
