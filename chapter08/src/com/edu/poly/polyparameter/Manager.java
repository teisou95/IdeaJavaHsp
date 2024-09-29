package com.edu.poly.polyparameter;

public class Manager extends Employee {
    private double bones;

    public Manager(String name, double salary, double bones) {
        super(name, salary);
        this.bones = bones;
    }
    public void manage() {
        System.out.println(getName() + "经理正在管理");
    }

    @Override
    public double getAnnual() {
        return super.getAnnual() + bones;
    }
}
