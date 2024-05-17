package solid;

import org.javatuples.Triplet;

import java.util.ArrayList;
import java.util.List;

// Dependency Inversion Principle
/*      A. High-level modules should not depend on Low-level modules
*          Both should depend on abstractions
*       B. Abstraction should not depend on details
*          Details should depend on abstractions */
public class DIP {
    public static void main(String[] args) {
        Person parent = new Person("John");
        Person child1 = new Person("Child");
        Person child2 = new Person("Matt");

        Relationships r = new Relationships();
        r.addParentAndChild(parent, child1);
        r.addParentAndChild(parent, child2);

        new Research(r);

        /* 1. The above code works fine, but constructor of Research class breaks DIP-A as it depends
        *     on low level Relationships module as an arg */

        /* 2. implementing it this way abides by the DIP */
    }
}


enum Relationship {
    PARENT, CHILD, SIBLING
}

class Person {
    public String name;
    public Person(String name) {
        this.name = name;
    }
}

// Low-level module as it acts as a data-store of relations and does not has any business logic
class Relationships {
    private List<Triplet<Person, Relationship, Person>> relations = new ArrayList<>();

    public List<Triplet<Person, Relationship, Person>> getRelations() {
        return relations;
    }

    public void addParentAndChild(Person person1, Person person2) {
        relations.add(new Triplet<>(person1, Relationship.PARENT, person2));
        relations.add(new Triplet<>(person2, Relationship.CHILD, person1));
    }
}

// High-level module as it allows us to perform some operations on the low-level construct above
class Research {
    public Research(Relationships relationships) {
        List<Triplet<Person, Relationship, Person>> relations = relationships.getRelations();
        relations.stream().filter(x -> x.getValue0().name.equals("John")
            && x.getValue1() == Relationship.PARENT)
                .forEach(x -> System.out.println("John has a child called " + x.getValue2().name));
    }

    // 2.
    public Research(RelationshipBrowser browser) {
        List<Person> childrens = browser.findAllChildrenOf("John");
        childrens.forEach(c -> System.out.println("John has a child called " + c.name));
    }
}

// 2.
interface RelationshipBrowser {
    List<Person> findAllChildrenOf(String name);
}
// class Relationships implements RelationshipBrowser {}
