package com.edu.homework.t05;

public class Scientist extends Employee {
    private double bonus; // 年终奖

    public Scientist(String name, double sal, double bonus) {
        super(name, sal);
        this.bonus = bonus;
    }

    @Override
    public double yearSal() {
        return super.yearSal() + bonus;
    }
}
