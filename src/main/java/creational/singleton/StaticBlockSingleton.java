package creational.singleton;

import java.io.File;
import java.io.IOException;

// use below static singleton when the constructor might throw error
public class StaticBlockSingleton {
    public static void main(String[] args) {
        StaticSingleton singleton = StaticSingleton.getInstance();
    }
}

class StaticSingleton {
    private StaticSingleton() throws IOException {
        System.out.println("Singleton is initializing");
        File.createTempFile(".", ".");
    }

    private static StaticSingleton instance;

    static {
        try {
            instance = new StaticSingleton();
        } catch (Exception e) {
            System.err.println("failed to create singleton");
        }
    }

    public static StaticSingleton getInstance() {
        return instance;
    }
}
