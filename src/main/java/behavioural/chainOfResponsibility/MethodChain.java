package behavioural.chainOfResponsibility;

/*
  Chain of Responsibility - A chain of components who all get a chance to process a
      command or a query, optionally having default processing implementation and an
      ability to terminate the processing chain

    1. can be implemented as a chain of references or a centralized construct
    2. enlist objects in the chain, possibly controlling their order
    3. object removal from chain (e.g. in AutoCloseable's close())
* */
class Creature {
    public String name;
    public int attack, defense;

    public Creature(String name, int attack, int defense) {
        this.name = name;
        this.attack = attack;
        this.defense = defense;
    }

    @Override
    public String toString() {
        return "Creature{ " +
                "name=" + name + "\'" +
                ", attack=" + attack +
                ", defense=" + defense + "}";
    }
}

// base class
class CreatureModifier {
    protected Creature creature;
    protected CreatureModifier next;

    public CreatureModifier(Creature creature) {
        this.creature = creature;
    }

    public void add(CreatureModifier cm) {
        if (next != null) {
            next.add(cm);
        } else {
            next = cm;
        }
    }

    public void handle() {
        // iteration to call handle method for all chain of modifiers
        if (next != null)   next.handle();
    }
}

class DoubleAttackModifier extends CreatureModifier {
    public DoubleAttackModifier(Creature creature) {
        super(creature);
    }

    @Override
    public void handle() {
        System.out.println("Doubling " + creature.name + "'s attack");
        creature.attack *= 2;
        super.handle();
    }
}

class IncreaseDefenseModifier extends CreatureModifier {
    public IncreaseDefenseModifier(Creature creature) {
        super(creature);
    }

    @Override
    public void handle() {
        System.out.println("Increasing " + creature.name + "'s defense");
        creature.defense += 3;
        super.handle();
    }
}

// 2.
class NoBonusesModifier extends CreatureModifier {
    public NoBonusesModifier(Creature creature) {
        super(creature);
    }

    @Override
    public void handle() {
        // nothing
        System.out.println("No bonuses for you !");
    }
}

public class MethodChain {
    public static void main(String[] args) {
        Creature goblin = new Creature("Goblin", 2, 2);
        System.out.println(goblin);

        CreatureModifier root = new CreatureModifier(goblin);

        System.out.println("Let's double Goblin's attack...");
        root.add(new DoubleAttackModifier(goblin));

        // 2. to break the chain of responsibility
        root.add(new NoBonusesModifier(goblin));

        System.out.println("Let's increase Goblin's defense...");
        root.add(new IncreaseDefenseModifier(goblin));

        root.handle();
        System.out.println(goblin);
    }
}
