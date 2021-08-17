package com.pluralsight.org.builder;

public class LunchOrderBeanDemo {

    public static void main(String[] args) {
        LunchOrderBean bean = new LunchOrderBean();

        // the problem being here is that even if we commented out below lines,
        // no error would be there as no contract has been implemented as to which
        // all variables out of the below must definitely be provided !!
        bean.setBread("Wheat");
        bean.setCondiments("Lettuce");
        bean.setDressing("Mustard");
        bean.setMeat("Ham");

        System.out.println(bean.getBread());
        System.out.println(bean.getCondiments());
        System.out.println(bean.getDressing());
        System.out.println(bean.getMeat());
    }
}
