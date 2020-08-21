package com.udacity.springbootbootstrap.service;

import com.udacity.springbootbootstrap.entity.Dog;
import com.udacity.springbootbootstrap.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogServiceImpl implements DogService {

    @Autowired
    private DogRepository dogRepository;

    public List<String> retrieveDogBreeds(){
        return dogRepository.findAllBreeds();
    }

    public String retrieveDogBreedById(Long id){
        return dogRepository.findBreedById(id);
    }

    public List<String> retrieveDogNames(){
        return dogRepository.findDogNames();
    }

    public List<Dog> findAllDogs(){
        return (List<Dog>)dogRepository.findAll();
    }
}
