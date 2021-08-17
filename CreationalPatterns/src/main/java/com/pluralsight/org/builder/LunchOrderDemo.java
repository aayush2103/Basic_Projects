package com.pluralsight.org.builder;

public class LunchOrderDemo {

    public static void main(String[] args) {
        LunchOrder.Builder builder = new LunchOrder.Builder();
        builder.bread("Wheat").condiments("Lettuce").dressing("Mustard").meat("Ham");

        LunchOrder order = builder.build();
        displayDetails(order);

        LunchOrder.Builder builder2 = new LunchOrder.Builder();
        builder2.bread("Wheat").meat("Turkey");
        LunchOrder order2 = builder2.build();
        displayDetails(order2);
    }

    private static void displayDetails(LunchOrder order) {
        System.out.println(order.getBread());
        System.out.println(order.getCondiments());
        System.out.println(order.getDressing());
        System.out.println(order.getMeat());
    }
}
