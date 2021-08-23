package com.pluralsight.org.abstractFactory;

public class VisaBlackValidator implements Validator {
    @Override
    public boolean isValid(CreditCard creditCard) {
        return false;
    }
}
