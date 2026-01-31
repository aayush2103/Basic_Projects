package creational.prototype;

import java.util.Arrays;

// Prototype - A partially or fully initialized object that you copy (clone) and make use of it
// to clone the Prototype
//      - implement your own deep copy functionality
//      - serialize and deserialize
public class UsingCloneable {
    public static void main(String[] args) throws Exception {
        Person john = new Person(new String[]{"John", "Smith"},
                new Address("London Street Road", 123));

        // 1. below line will create problem as we are just copying the reference - shallow copy
//        Person jane = john;

        // deep copy - below copies each member value using clone method implemented
        Person jane = (Person) john.clone();
        jane.names[0] = "Jane";
        jane.address.houseNumber = 124;
        System.out.println(john);
        System.out.println(jane);
    }
}

class Address implements Cloneable {
    public String streetName;
    public int houseNumber;

    public Address(String streetName, int houseNumber) {
        this.streetName = streetName;
        this.houseNumber = houseNumber;
    }

    @Override
    public String toString() {
        return "Address { streetName - " + streetName +
                ", houseNumber - " + houseNumber + " }";
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return new Address(streetName, houseNumber);
    }
}

class Person implements Cloneable {
    public String[] names;
    public Address address;

    public Person(String[] names, Address address) {
        this.names = names;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person { name - " + Arrays.toString(names) +
                ", " + address + " }";
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        // 2. below line will again create problem as we are doing shallow copy
//        return new Person(names, address);

        // 3. below will work as we are doing deep copy using clone implemented method
        return new Person(names.clone(), (Address) address.clone());
    }
}
