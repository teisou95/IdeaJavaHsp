package com.edu.homework.t11;

public class Homework11 {
    public static void main(String[] args) {
        Person hana = new Student(); // 向上转型
        hana.eat(); // Person eat
        hana.run(); // Student run

        Student s1 = (Student) hana; // 向下转型
        s1.run(); // S
        s1.study(); // S
        s1.eat(); // P

    }
}
