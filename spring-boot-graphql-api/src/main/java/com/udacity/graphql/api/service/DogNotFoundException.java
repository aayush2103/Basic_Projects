package com.udacity.graphql.api.service;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DogNotFoundException extends RuntimeException implements GraphQLError {

    private Map<String, Object> extensions = new HashMap<>();

    public DogNotFoundException(String message, Long id){
        super(message);
        extensions.put("invalidDogId", id);
    }

    public DogNotFoundException(String message, String breed){
        super(message);
        extensions.put("invalidDogBreed", breed);
    }

    @Override
    public List<SourceLocation> getLocations(){
        return null;
    }

    @Override
    public Map<String, Object> getExtensions(){
        return extensions;
    }

    @Override
    public ErrorType getErrorType(){
        return ErrorType.DataFetchingException;
    }
}
