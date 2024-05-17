package solid;

import java.util.List;
import java.util.stream.Stream;

// Open Close Principle and Specification
//      - classes should be open for extension but closed for modification
public class OCP {
    public static void main(String[] args) {
        /* 1. here we are using the ProductFilter class to handle the filter methods
        *     which will lead to many method implementations in future with various combinations
        *     this does not abide by the OCP and Specification principles */
        Product apple = new Product("Apple", Color.GREEN, Size.SMALL);
        Product tree = new Product("Tree", Color.GREEN, Size.LARGE);
        Product house = new Product("House", Color.BLUE, Size.LARGE);

        List<Product> products = List.of(apple, tree, house);

        ProductFilter pf = new ProductFilter();
        System.out.println("Green products (Old): ");
        pf.filterByColor(products, Color.GREEN)
                .forEach(p -> System.out.println(" - " + p.name + " is green"));

        /* 2.  here we implement the filter etc methods using 2 new interfaces (which are open for extension)
        *      which reduce the modification of ProductFilter class in future for each new filter to be added*/
        BetterFilter bf = new BetterFilter();
        System.out.println("Green products (New): ");
        bf.filter(products, new ColorSpecification(Color.GREEN))
                .forEach(p -> System.out.println(" - " + p.name + " is green"));


        /* 3.  this can even be combined for multiple filters*/
        System.out.println("Green and Large products (New): ");
        bf.filter(products, new AndSpecification(Color.GREEN, Size.LARGE))
                .forEach(p -> System.out.println(" - " + p.name + " is green and large"));
    }
}


// 1.
enum Color {
    GREEN, RED, BLUE
}

enum Size {
    SMALL, MEDIUM, LARGE, HUGE
}

class Product {

    public String name;
    public Color color;
    public Size size;

    public Product(String name, Color color, Size size) {
        this.name = name;
        this.color = color;
        this.size = size;
    }
}

class ProductFilter {

    public Stream<Product> filterByColor(List<Product> products, Color color) {
        return products.stream().filter(p -> p.color == color);
    }

    public Stream<Product> filterBySize(List<Product> products, Size size) {
        return products.stream().filter(p -> p.size == size);
    }

    public Stream<Product> filterByColorAndSize(List<Product> products, Color color, Size size) {
        return products.stream().filter(p -> p.color == color && p.size == size);
    }
}

// 2.
interface Specification<T> {
    boolean isSatisfied(T item);
}

interface Filter<T> {
    Stream<T> filter(List<T> items, Specification spec);
}

class ColorSpecification implements Specification<Product> {

    private Color color;

    public ColorSpecification(Color color) {
        this.color = color;
    }

    @Override
    public boolean isSatisfied(Product p) {
        return p.color == color;
    }
}

class SizeSpecification implements Specification<Product> {

    private Size size;

    public SizeSpecification(Size size) {
        this.size = size;
    }

    @Override
    public boolean isSatisfied(Product p) {
        return p.size == size;
    }
}

class BetterFilter implements Filter<Product> {

    @Override
    public Stream<Product> filter(List<Product> items, Specification spec) {
        return items.stream().filter(p -> spec.isSatisfied(p));
    }
}

// 3.
class AndSpecification implements Specification<Product> {

    private Color color;
    private Size size;

    public AndSpecification(Color color, Size size) {
        this.color = color;
        this.size = size;
    }

    @Override
    public boolean isSatisfied(Product item) {
        return item.color == color && item.size == size;
    }
}
