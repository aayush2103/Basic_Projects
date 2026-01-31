package creational.singleton;

// use this to lazily initialize the Singleton object
public class LazySingleton {
    public static void main(String[] args) {
        LazySingleton1 singleton1 = LazySingleton1.getInstance();
    }
}

class LazySingleton1 {
    private static LazySingleton1 instance;

    private LazySingleton1() {
        System.out.println("singleton is being initialized lazily");
    }

    /* below method can create 2 instances in a multi-threaded environment
    public static LazySingleton1 getInstance() {
        if (instance == null) {
            instance = new LazySingleton1();
        }
        return instance;
    }
    */

    // to solve above problem, we use below method - double-checked locking
    public static LazySingleton1 getInstance() {
        if (instance == null) {
            synchronized (LazySingleton1.class) {
                if (instance == null) {
                    instance = new LazySingleton1();
                }
            }
        }
        return instance;
    }
}