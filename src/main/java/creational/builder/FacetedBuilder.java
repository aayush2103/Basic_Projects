package creational.builder;

// Builder - when piecewise object construction is complicated, provide an api for doing it succinctly

/* This class demonstrates use of a facade class to combine multiple builder classes */
public class FacetedBuilder {
    public static void main(String[] args) {
        PersonBuilder pb = new PersonBuilder();
        Person person = pb
                .lives()
                    .at("123 London Road")
                    .in("London")
                    .withPostcode("SW12BC")
                .works()
                    .at("Fabrikam")
                    .asA("Engineer")
                    .earning(123000)
                .build();

        System.out.println(person);
    }
}

class Person {
    // address fields
    public String streetName, postcode, city;

    // employment details
    public String companyName, position;
    public int annualIncome;

    @Override
    public String toString() {
        return "Person { " +
                "streetAddress - " + streetName +
                ", city - " + city + ", post code - " + postcode +
                ", company name - " + companyName +
                ", position - " + position + ", annual income - " + annualIncome + " }";
    }
}

// facade builder
class PersonBuilder {
    protected Person person = new Person();

    public PersonAdressBuilder lives() {
        return new PersonAdressBuilder(person);
    }

    public PersonJobBuilder works() {
        return new PersonJobBuilder(person);
    }

    public Person build() {
        return person;
    }

}

class PersonJobBuilder extends PersonBuilder {
    public PersonJobBuilder(Person person) {
        this.person = person;
    }

    // when method returns the builder class itself, is called 'fluent builder'
    // this gives the power to concatenate and call multiple methods together as in main method above
    public PersonJobBuilder at(String company) {
        person.companyName = company;
        return this;
    }

    public PersonJobBuilder asA(String position) {
        person.position = position;
        return this;
    }

    public PersonJobBuilder earning(int income) {
        person.annualIncome = income;
        return this;
    }
}

class PersonAdressBuilder extends PersonBuilder {

    public PersonAdressBuilder(Person person) {
        this.person = person;
    }

    public PersonAdressBuilder at(String street) {
        person.streetName = street;
        return this;
    }

    public PersonAdressBuilder in(String city) {
        person.city = city;
        return this;
    }

    public PersonAdressBuilder withPostcode(String postCode) {
        person.postcode = postCode;
        return this;
    }
}