package com.edu.homework.t05;

public class Employee {
    private String name;
    private double sal; // 月基本工资
    private int salMonth = 12; // 带薪月数,默认12个月

    public Employee(String name, double sal) {
        this.name = name;
        this.sal = sal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public int getSalMonth() {
        return salMonth;
    }

    public void setSalMonth(int salMonth) {
        this.salMonth = salMonth;
    }

    // 全年工资
    public double yearSal() {
        return salMonth * sal;
    }
}
