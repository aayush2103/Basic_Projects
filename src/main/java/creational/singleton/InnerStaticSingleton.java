package creational.singleton;

// this avoids using 'synchronised' as this is totally thread safe and guarantees providing/creating only 1 instance of singleton
public class InnerStaticSingleton {
    public static void main(String[] args) {
        IStaticSingleton singleton = IStaticSingleton.getInstance();
    }
}

class IStaticSingleton {
    private IStaticSingleton() {}

    private static class Impl {
        private static final IStaticSingleton INSTANCE = new IStaticSingleton();
    }

    public static IStaticSingleton getInstance() {
        return Impl.INSTANCE;
    }
}
