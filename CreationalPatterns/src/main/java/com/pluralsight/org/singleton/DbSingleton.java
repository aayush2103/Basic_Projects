package com.pluralsight.org.singleton;

public class DbSingleton {

    private static volatile DbSingleton instance = null;

    private DbSingleton() {
        // if instance already created by another thread
        if(instance != null) {
            throw new RuntimeException("use getInstance() method to get an object");
        }
    }

    public static DbSingleton getInstance() {
        if(instance == null) {
            // synchronize block for thread safety
            synchronized(DbSingleton.class) {
                // if instance already instantiated by another thread inside synchronized block
                if(instance == null) {
                    instance = new DbSingleton();
                }
            }
        }
        return instance;
    }
}
