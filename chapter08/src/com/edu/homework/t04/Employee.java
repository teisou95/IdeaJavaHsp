package com.edu.homework.t04;

public class Employee {
    private String name;
    private double daySal;
    private int workDays;
    private double grade;
    private double sumSal;

    public void printSal() {
        System.out.println(name + "的工资是" + sumSal);
    }

    public Employee(String name, double daySal, int workDays) {
        this.name = name;
        this.daySal = daySal;
        this.workDays = workDays;
    }

    public double getSumSal() {
        return sumSal;
    }

    public void setSumSal(double sumSal) {
        this.sumSal = sumSal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDaySal() {
        return daySal;
    }

    public void setDaySal(double daySal) {
        this.daySal = daySal;
    }

    public int getWorkDays() {
        return workDays;
    }

    public void setWorkDays(int workDays) {
        this.workDays = workDays;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}
