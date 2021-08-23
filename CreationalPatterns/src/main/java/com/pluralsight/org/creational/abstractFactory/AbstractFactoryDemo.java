package com.pluralsight.org.creational.abstractFactory;

public class AbstractFactoryDemo {

    public static void main(String[] args) {
        CreditCardFactory abstractfactory = CreditCardFactory.getCreditCardFactory(775);
        CreditCard factory = abstractfactory.getCreditCard(CardType.GOLD);
        System.out.println(factory.getClass());

        abstractfactory = CreditCardFactory.getCreditCardFactory(600);
        factory = abstractfactory.getCreditCard(CardType.PLATINUM);
        System.out.println(factory.getClass());
    }
}
