package com.edu.poly.polyarr;

public class Student extends Person {
    private double score;

    public Student(String name, int age, double score) {
        super(name, age);
        this.score = score;
    }

    @Override
    public void say() {
        super.say();
        System.out.print("\tscore = " + score);
    }


    public void study() {
        System.out.println(getName() + "学生正在学习...");
    }
}
