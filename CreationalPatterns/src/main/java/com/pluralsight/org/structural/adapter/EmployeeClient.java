package com.pluralsight.org.structural.adapter;

import java.util.ArrayList;
import java.util.List;

public class EmployeeClient {

    public List<Employee> getEmployeeList() {
        Employee employee = new EmployeeDB(1234, "John", "Wick", "john@wick.com");

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee);

        EmployeeDap empDap = new EmployeeDap(5678, "Chris", "Hemsworth", "chris@hemsworth.com");
        //passing new Object of EmployeeDap with Adapter EmployeeAdapterDap
        employeeList.add(new EmployeeAdapterDap(empDap));

        return employeeList;
    }
}
