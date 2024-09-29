package com.edu.extend_.improve;

// Pupil 和Graduate 的父类
public class Student {
    // 共有属性与方法
    public String name;
    public int age;
    private double score;

    public void setScore(double score) {
        this.score = score;
    }

    public void showInfo() {
        System.out.println("学生 " + name + " 的年龄" + age + "岁,成绩" + score);
    }
}
