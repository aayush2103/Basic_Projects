package com.udacity.graphql.api.mutator;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.udacity.graphql.api.entity.Dog;
import com.udacity.graphql.api.repository.DogRepository;
import com.udacity.graphql.api.service.DogNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class Mutation implements GraphQLMutationResolver {
    private DogRepository dogRepository;

    public Mutation(DogRepository dogRepository){
        this.dogRepository = dogRepository;
    }

    public Dog newDog(String name, String breed, String origin){
        Dog newDog = new Dog(name, breed, origin);
        dogRepository.save(newDog);
        return newDog;
    }

    public Boolean deleteDogBreed(String breed){
        List<Dog> dogList = dogRepository.findDogsByBreed(breed);
        if(dogList.isEmpty()){
            throw new DogNotFoundException("Dog Breed not found ", breed);
        }
        for(Dog dog: dogList) {
            dogRepository.delete(dog);
        }
        return true;
    }

    public Dog updateDogName(String name, Long id){
        Optional<Dog> optionalDogObject = dogRepository.findById(id);

        if(optionalDogObject.isPresent()){
            Dog dogObject = optionalDogObject.get();
            dogObject.setName(name);
            dogRepository.save(dogObject);
            return dogObject;
        }else{
            throw new DogNotFoundException("Dog not found ", id);
        }
    }
}
