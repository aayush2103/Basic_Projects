package creational.prototype;

// Copy Constructor is better than using Cloneable
public class UsingCopyConstructor {
    public static void main(String[] args) {
        Employee john = new Employee("John",
                new NewAddress("123 London Street Road", "London", "UK"));
        Employee jane = new Employee(john);
        jane.name = "Jane";
        jane.address.streetName = "124 London Street Road";

        System.out.println(john);
        System.out.println(jane);
    }
}


class NewAddress {
    public String streetName, city, country;

    public NewAddress(String streetName, String city, String country) {
        this.streetName = streetName;
        this.city = city;
        this.country = country;
    }

    // this is called the 'Copy Constructor' method
    public NewAddress(NewAddress other) {
        this(other.streetName, other.city, other.country);
    }

    @Override
    public String toString() {
        return "NewAddress { streetName - " + streetName +
                ", city - " + city + ", country - " + country + " }";
    }
}

class Employee {
    public String name;
    public NewAddress address;

    public Employee(String name, NewAddress address) {
        this.name = name;
        this.address = address;
    }

    // this is called the 'Copy Constructor' method
    public Employee(Employee other) {
        name = other.name;
        address = new NewAddress(other.address);
    }

    @Override
    public String toString() {
        return "Employee { name - " + name +
                ", " + address + " }";
    }
}