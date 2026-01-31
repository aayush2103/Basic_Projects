package creational.singleton;

import java.io.PrintStream;
import java.util.HashMap;

// use this when you want to have a singe instance each for different types of Singleton
public class Multiton {
    public static void main(String[] args) {
        Printer pri = Printer.get(Subsystem.PRIMARY);
        Printer aux = Printer.get(Subsystem.AUXILIARY);
        Printer fb = Printer.get(Subsystem.FALLBACK);

        // constructor does'nt gets called for below
        Printer aux2 = Printer.get(Subsystem.AUXILIARY);
    }
}

enum Subsystem {
    PRIMARY, AUXILIARY, FALLBACK;
}

class Printer {

    // diagnostic
    private static int instanceCounter = 0;

    private Printer() {
        instanceCounter++;
        System.out.println("A total of " + instanceCounter + " instances have been created so far.");
    }

    private static HashMap<Subsystem, Printer> instances = new HashMap<>();

    // lazy loading
    // only 3 instances each of type Subsystem can be created ever
    public static Printer get(Subsystem ss) {
        if (instances.containsKey(ss))
            return instances.get(ss);

        Printer instance = new Printer();
        instances.put(ss, instance);
        return instance;
    }
}