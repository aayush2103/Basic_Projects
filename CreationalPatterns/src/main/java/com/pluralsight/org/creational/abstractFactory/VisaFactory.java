package com.pluralsight.org.creational.abstractFactory;

//Concrete factory
public class VisaFactory extends CreditCardFactory {

    @Override
    public CreditCard getCreditCard(CardType cardType) {
        switch(cardType) {
            case GOLD :
                return new VisaGoldCreditCard();
            case PLATINUM :
                return new VisaBlackCreditCard();
            default :
                return null;
        }
    }

    @Override
    public Validator getValidator(CardType cardType) {
        switch (cardType) {
            case GOLD :
                return new VisaGoldValidator();
            case PLATINUM :
                return new VisaBlackValidator();
            default :
                return null;
        }
    }
}
