package com.edu.homework.t04;

public class Staff extends Employee {
    public Staff(String name, double daySal, int day) {
        super(name, daySal, day);
        setGrade(1.0);
    }

    @Override
    public void printSal() {
        setSumSal(getDaySal() * getWorkDays() * getGrade());
        super.printSal();
    }
}
