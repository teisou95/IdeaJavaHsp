package com.edu.poly.polyarr;

public class Teacher extends Person {
    private double salary;

    public Teacher(String name, int age, double salary) {
        super(name, age);
        this.salary = salary;
    }

    @Override
    public void say() {
        super.say();
        System.out.print("\tsalary = " + salary);
    }


    public void teach() {
        System.out.println(getName() + "老师正在教书...");
    }
}
