package creational.factory;

import org.javatuples.Pair;
import org.reflections.Reflections;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

// The idea of Abstract Factory pattern is that if you have a heirarchy of types,
// you can have a corresponding heirarchy of factories related to those types
public class AbstractFactoryPattern {
    public static void main(String[] args) throws Exception {
        HotDrinkMachine machine = new HotDrinkMachine();
        HotDrink drink = machine.makeDrink();
        drink.consume();
    }
}


interface HotDrink {
    public void consume();
}

class Tea implements HotDrink {
    @Override
    public void consume() {
        System.out.println("Your Tea is ready !");
    }
}

class Coffee implements HotDrink {
    @Override
    public void consume() {
        System.out.println("Your coffee is ready !");
    }
}

interface HotDrinkFactory {
    public HotDrink prepare(int amount);
}

class TeaFactory implements HotDrinkFactory {
    @Override
    public HotDrink prepare(int amount) {
        System.out.println("Put tea bag in cup, boil water, pour " +
                amount + "ml, add lemon, enjoy !");
        return new Tea();
    }
}

class CoffeeFactory implements HotDrinkFactory {
    @Override
    public HotDrink prepare(int amount) {
        System.out.println("Grind some beans, boil water, pour " +
                amount + "ml, add cream and sugar, enjoy !");
        return new Coffee();
    }
}

class HotDrinkMachine {
    private List<Pair<String, HotDrinkFactory>> namedFactories = new ArrayList<>();

    // get all available factories to create hot drink
    public HotDrinkMachine() throws Exception {
        Set<Class<? extends HotDrinkFactory>> types =
                new Reflections("creational.factory").getSubTypesOf(HotDrinkFactory.class);

        for (Class<? extends HotDrinkFactory> type: types) {
            namedFactories.add(new Pair<>(
                    type.getSimpleName().replace("Factory", ""),
                    type.getDeclaredConstructor().newInstance()
            ));
        }
    }

    public HotDrink makeDrink() throws Exception {
        System.out.println("Available drinks :");
        for (int i = 0; i < namedFactories.size(); i++) {
            Pair<String, HotDrinkFactory> item = namedFactories.get(i);
            System.out.println("" + i + ": " + item.getValue0());
        }

        // get user input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String s;
            int i, amount;

            if ((s = br.readLine()) != null && (i = Integer.parseInt(s)) >= 0 && i < namedFactories.size()) {
                System.out.println("Specify amount : ");
                s = br.readLine();

                if (s != null && (amount = Integer.parseInt(s)) > 0) {
                    return namedFactories.get(i).getValue1().prepare(amount);
                }
            }
            System.out.println("Incorrect input, try again.");
        }
    }
}