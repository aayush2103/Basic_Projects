package com.pluralsight.org.structural.adapter;

public class EmployeeDB implements Employee {
    private String id;
    private String firstName;
    private String lastName;
    private String email;

    public EmployeeDB(String id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public String toString() {
        return "ID: " + getId() + ", First Name: " + getFirstName() + ", Last Name: " + getLastName()
                + ", Email: " + getEmail();
    }
}
