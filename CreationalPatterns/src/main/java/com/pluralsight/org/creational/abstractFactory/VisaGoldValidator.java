package com.pluralsight.org.creational.abstractFactory;

public class VisaGoldValidator implements Validator {
    @Override
    public boolean isValid(CreditCard creditCard) {
        return false;
    }
}
