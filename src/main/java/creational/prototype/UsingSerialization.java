package creational.prototype;

import org.apache.commons.lang3.SerializationUtils;

import java.io.Serializable;

// much better to use as these traverse the whole object graph to create a deep copy of the object
public class UsingSerialization {
    public static void main(String[] args) {
        Foo foo = new Foo(42, "life");
        Foo foo2 = SerializationUtils.roundtrip(foo);
        foo2.whatever = "xyz";

        System.out.println(foo);
        System.out.println(foo2);
    }
}

class Foo implements Serializable {
    public int stuff;
    public String whatever;

    public Foo(int stuff, String whatever) {
        this.stuff = stuff;
        this.whatever = whatever;
    }

    @Override
    public String toString() {
        return "Foo { stuff - " + stuff +
                ", whatever - " + whatever + " }";
    }
}