package com.edu.static_;

public class StaticExercise02 {
    public static void main(String[] args) {
        System.out.println("Number of total is " + Person.getTotalPerson()); // 0
        Person p1 = new Person(); // Person.total = 1, p1.id = 1
        System.out.println("Number of total is " + Person.getTotalPerson()); // 1

    }
}

class Person {
    private int id;
    private static int total = 0;

    public static int getTotalPerson() {
//        id++; // 静态方法不能访问非静态变量
        return total;
    }

    public Person() {
        total++;
        this.id = total;
    }
}