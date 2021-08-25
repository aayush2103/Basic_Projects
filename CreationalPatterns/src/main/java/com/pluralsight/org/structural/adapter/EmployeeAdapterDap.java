package com.pluralsight.org.structural.adapter;

//Adapter class
public class EmployeeAdapterDap implements Employee {
    private EmployeeDap instance;

    public EmployeeAdapterDap(EmployeeDap instance) {
        this.instance = instance;
    }

    @Override
    public int getId() {
        return this.instance.getCn();
    }

    @Override
    public String getFirstName() {
        return this.instance.getGivenName();
    }

    @Override
    public String getLastName() {
        return this.instance.getSurname();
    }

    @Override
    public String getEmail() {
        return this.instance.getEmail();
    }
}
