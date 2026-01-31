package creational.singleton;

import java.io.*;

// Singleton - a component which is instantiated only once
public class BasicSingleton {
    public static void main(String[] args) throws Exception {
        Singleton singleton = Singleton.getInstance();
        singleton.setValue(123);
        System.out.println(singleton.getValue());

        // problems with Singleton object
        // 1. reflection - using this multiple instances of Singleton object can be created
        // 2. serialization -
        String filename = "singleton.bin";
        writeToFile(singleton, filename);
        singleton.setValue(456);

        Singleton singleton2 = readFromFile(filename);

        System.out.println(singleton == singleton2);
        System.out.println(singleton.getValue());
        System.out.println(singleton2.getValue());
    }

    // 2.
    static void writeToFile(Singleton singleton, String filename) throws Exception {
        try (FileOutputStream fileOut = new FileOutputStream(filename);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(singleton);
        }
    }
    static Singleton readFromFile(String filename) throws Exception {
        try (FileInputStream fileIn = new FileInputStream(filename);
             ObjectInput in = new ObjectInputStream(fileIn)) {
            return (Singleton) in.readObject();
        }
    }
}

// 2. Serializable implementation added to demonstrate 2nd problem
class Singleton implements Serializable {
    private Singleton() {}

    private static final Singleton INSTANCE = new Singleton();

    public static Singleton getInstance() {
        return INSTANCE;
    }

    private int value = 0;

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    // 3. to protect from problem 2 above
    protected Object readResolve() {
        return INSTANCE;
    }
}
