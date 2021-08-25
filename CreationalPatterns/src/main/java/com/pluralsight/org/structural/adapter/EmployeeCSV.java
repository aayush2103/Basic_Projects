package com.pluralsight.org.structural.adapter;

import java.util.StringTokenizer;

public class EmployeeCSV {

    private int id;
    private String firstName;
    private String lastName;
    private String emailAddress;

    public EmployeeCSV(String values) {
        StringTokenizer tokenizer = new StringTokenizer(values, ",");
        if(tokenizer.hasMoreElements()) {
            this.id = Integer.parseInt(tokenizer.nextToken());
        }
        if(tokenizer.hasMoreElements()) {
            this.firstName = tokenizer.nextToken();
        }
        if(tokenizer.hasMoreElements()) {
            this.lastName = tokenizer.nextToken();
        }
        if(tokenizer.hasMoreElements()) {
            this.emailAddress = tokenizer.nextToken();
        }
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
}
