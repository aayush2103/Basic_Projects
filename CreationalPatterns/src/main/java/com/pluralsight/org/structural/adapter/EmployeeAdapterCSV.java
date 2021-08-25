package com.pluralsight.org.structural.adapter;

public class EmployeeAdapterCSV implements Employee {

    private EmployeeCSV instance;

    public EmployeeAdapterCSV(EmployeeCSV instance) {
        this.instance = instance;
    }

    @Override
    public String getId() {
        return this.instance.getId() + "";
    }

    @Override
    public String getFirstName() {
        return this.instance.getFirstName();
    }

    @Override
    public String getLastName() {
        return this.instance.getLastName();
    }

    @Override
    public String getEmail() {
        return this.instance.getEmailAddress();
    }
}
