package com.edu.homework.t05;

public class Teacher extends Employee {
    private int classDay; // 年工作天数
    private double classSal; // 课酬,元/天

    public Teacher(String name, double sal, int classDay, double classSal) {
        super(name, sal);
        this.classDay = classDay;
        this.classSal = classSal;
    }

    @Override
    public double yearSal() {
        return super.yearSal() + classDay * classSal;
    }
}
