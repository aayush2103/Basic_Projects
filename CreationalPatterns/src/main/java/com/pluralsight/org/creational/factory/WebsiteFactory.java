package com.pluralsight.org.creational.factory;

public class WebsiteFactory {

    public static Website getWebsite(WebsiteType siteName) {
        switch(siteName) {
            case BLOG : {
                return new Blog();
            }
            case SHOP : {
                return new Shop();
            }
            default : {
                return null;
            }
        }
    }
}
