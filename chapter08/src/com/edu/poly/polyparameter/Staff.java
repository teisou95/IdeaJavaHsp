package com.edu.poly.polyparameter;

public class Staff extends Employee {
    public Staff(String name, double salary) {
        super(name, salary);
    }
    public void work() {
        System.out.println(getName() + "员工正在工作");
    }

    @Override
    public double getAnnual() {
        return super.getAnnual();
    }
}
