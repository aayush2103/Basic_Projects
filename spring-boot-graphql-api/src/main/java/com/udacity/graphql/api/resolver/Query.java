package com.udacity.graphql.api.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udacity.graphql.api.entity.Dog;
import com.udacity.graphql.api.repository.DogRepository;
import com.udacity.graphql.api.service.DogNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Query implements GraphQLQueryResolver {
    private DogRepository dogRepository;

    public Query(DogRepository dogRepository){
        this.dogRepository = dogRepository;
    }

    public Iterable<Dog> findAllDogs(){
        return dogRepository.findAll();
    }

    public Dog findDogById(Long id){
        Optional<Dog> optionalDogObject = dogRepository.findById(id);
        if(optionalDogObject.isEmpty())
            throw new DogNotFoundException("Dog not found ", id);
        return optionalDogObject.get();
    }
}
