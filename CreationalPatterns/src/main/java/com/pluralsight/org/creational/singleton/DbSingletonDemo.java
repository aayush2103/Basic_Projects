package com.pluralsight.org.creational.singleton;

public class DbSingletonDemo {

    public static void main(String[] args) {
        DbSingleton singletonInstance = DbSingleton.getInstance();
        DbSingleton anotherInstance = DbSingleton.getInstance();

        System.out.println(singletonInstance);
        System.out.println(anotherInstance);

        if(singletonInstance == anotherInstance) {
            System.out.println("They are of the same instance");
        }
    }
}
