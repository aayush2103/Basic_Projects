package com.pluralsight.org.structural.adapter;

public class EmployeeDap {
    private int cn;
    private String givenName;
    private String surname;
    private String email;

    public EmployeeDap(int cn, String givenName, String surname, String email) {
        this.cn = cn;
        this.givenName = givenName;
        this.surname = surname;
        this.email = email;
    }

    public int getCn() {
        return cn;
    }

    public String getGivenName() {
        return givenName;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String toString() {
        return "ID: " + getCn() + ", First Name: " + getGivenName() + ", Last Name: " + getSurname()
                + ", Email: " + getEmail();
    }
}
