package com.pluralsight.org.creational.abstractFactory;

public class VisaBlackValidator implements Validator {
    @Override
    public boolean isValid(CreditCard creditCard) {
        return false;
    }
}
