package com.pluralsight.org.creational.prototype;

public class PrototypeDemo {

    public static void main(String[] args) {
        Registry registry = new Registry();
        Movie movie = (Movie) registry.createItem("Movie");
        movie.setTitle("Creational Patters in Java");
        displayDetails(movie);

        Movie anotherMovie = (Movie) registry.createItem("Movie");
        anotherMovie.setTitle("Gang of Four");
        displayDetails(anotherMovie);
    }

    private static void displayDetails(Movie movie) {
        System.out.println(movie);
        System.out.println(movie.getTitle());
        System.out.println(movie.getRuntime());
        System.out.println(movie.getUrl());
    }
}
