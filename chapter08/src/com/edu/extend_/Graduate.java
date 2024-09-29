package com.edu.extend_;
// 继承 提高代码复用性
// class 子类 extends 父类{}
// 父类/基类/超类
// 子类/派生类
// 子类可以继续派生

public class Graduate {
    public String name;
    public int age;
    private double score;

    public void setScore(double score) {
        this.score = score;
    }

    public void testing() { // 与 Pupil 不同的信息
        System.out.println("大学生 " + name + " 正在考试大学数学");
    }

    public void showInfo() {
        System.out.println("学生名" + name + " 年龄" + age + " 成绩" + score);
    }
}
