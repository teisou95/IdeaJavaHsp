package com.edu.homework.t04;

public class Master extends Employee {
    private double bonus;
    public Master(String name, double daySal, int day) {
        super(name, daySal, day);
        setGrade(1.2);
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public void printSal() {
        setSumSal(bonus + getDaySal() * getWorkDays() * getGrade());
        super.printSal();
    }
}
