package com.udacity.springbootbootstrap.web;

import com.udacity.springbootbootstrap.entity.Dog;
import com.udacity.springbootbootstrap.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DogController {

    private DogService dogService;

    @Autowired
    public void setDogService(DogService dogService){
        this.dogService = dogService;
    }

    @GetMapping("/dogs")
    public ResponseEntity<List<Dog>> getAllDogs(){
        List<Dog> dogList = dogService.findAllDogs();
        return new ResponseEntity<List<Dog>>(dogList, HttpStatus.OK);
    }

    @GetMapping("/dogs/breeds")
    public ResponseEntity<List<String>> findDogBreeds(){
        List<String> dogBreedsList = dogService.retrieveDogBreeds();
        return new ResponseEntity<List<String>>(dogBreedsList, HttpStatus.OK);
    }

    @GetMapping("/dogs/breed/{id}")
    public ResponseEntity<String> findBreedById(@PathVariable Long id){
        String breedById = dogService.retrieveDogBreedById(id);
        return new ResponseEntity<String>(breedById, HttpStatus.OK);
    }

    @GetMapping("/dogs/names")
    public ResponseEntity<List<String>> findAllDogNames(){
        List<String> allDogNames = dogService.retrieveDogNames();
        return new ResponseEntity<List<String>>(allDogNames, HttpStatus.OK);
    }
}
