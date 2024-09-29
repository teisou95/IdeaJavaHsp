package com.edu.homework.t13;

public class Student extends Person {
    private String stu_id;


    public Student(String name, char gender, int age, String stu_id) {
        super(name, gender, age);
        this.stu_id = stu_id;
    }

    public void study() {
        System.out.println("好好学习");
    }

    @Override
    public String play() {
        return super.play() + "足球";
    }

    @Override
    public void printInfo() {
        System.out.print("学生");
        super.printInfo();
        System.out.println("学号:" + stu_id);
        study();
        System.out.println(play());
    }

}
