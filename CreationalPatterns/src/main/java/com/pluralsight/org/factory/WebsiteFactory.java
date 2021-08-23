package com.pluralsight.org.factory;

public class WebsiteFactory {

    public static Website getWebsite(String siteName) {
        switch(siteName) {
            case "blog" : {
                return new Blog();
            }
            case "shop" : {
                return new Shop();
            }
            default : {
                return null;
            }
        }
    }
}
