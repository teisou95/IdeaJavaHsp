package com.edu.poly.polyarr;

public class Person {
    private String name;
    private int age;

    public void say() {
        System.out.print("name = " + name + "\tage = " + age);
    }

//    public void teach() {
////        System.out.println(name + "不是老师,不教书");
//    }
//
//    public void study() {
////        System.out.println(name + "不是学生,不学习");
//    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }
}
