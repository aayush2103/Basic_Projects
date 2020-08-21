package com.udacity.springbootbootstrap.service;

import com.udacity.springbootbootstrap.entity.Dog;

import java.util.List;

public interface DogService {
    List<String> retrieveDogBreeds();
    String retrieveDogBreedById(Long id);
    List<String> retrieveDogNames();
    List<Dog> findAllDogs();
}
