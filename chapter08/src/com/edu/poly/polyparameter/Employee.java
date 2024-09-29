package com.edu.poly.polyparameter;

public class Employee {
    private String name;
    private double salary;

    public double getAnnual() {
        return salary * 12;
    }

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

}
