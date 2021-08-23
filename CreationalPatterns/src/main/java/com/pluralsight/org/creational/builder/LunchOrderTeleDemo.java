package com.pluralsight.org.creational.builder;

public class LunchOrderTeleDemo {

    public static void main(String[] args) {
        LunchOrderTeleBean bean = new LunchOrderTeleBean("Wheat", "Lettuce",
                "Mustard","Ham");

        // Above bean has advantage over LunchOrderBean, as this is immutable and provides various
        // constructor options to implement contract, but it does not provide all the options
        // as in, what if we only wanted an object with bread and meat ?!
        // LunchOrderBean becomes advantageous at this point as it provides setter methods
        // to populate whatever variables we want
        // Hence, both have its advantages and disadvantages !!
        System.out.println(bean.getBread());
        System.out.println(bean.getCondiments());
        System.out.println(bean.getDressing());
        System.out.println(bean.getMeat());
    }
}
