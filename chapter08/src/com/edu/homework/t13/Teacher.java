package com.edu.homework.t13;

public class Teacher extends Person {
    private int work_age;

    public Teacher(String name, char gender, int age, int work_age) {
        super(name, gender, age);
        this.work_age = work_age;
    }

    public void teach() {
        System.out.println("好好教课");
    }

    @Override
    public String play() {
        return super.play() + "象棋";
    }

    @Override
    public void printInfo() {
        System.out.print("老师");
        super.printInfo();
        System.out.println("工龄:" + work_age);
        teach();
        System.out.println(play());
    }
}
