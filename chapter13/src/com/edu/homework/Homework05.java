package com.edu.homework;

import java.util.Objects;

public class Homework05 {
    public static void main(String[] args) {
        String s1 = "king";
        Animal a = new Animal(s1);
        Animal b = new Animal(s1);
        System.out.println(a == b); // f
        System.out.println(a.equals(b)); // f
        System.out.println(a.name == b.name); // t
        System.out.println("==============");
        String s4 = new String("king");
        String s5 = "king";
        System.out.println(s1 == s4); // f
        System.out.println(s4 == s5); // f
        System.out.println("==============");
        String t1 = "hello" + s1; // 本质上 new StringBuilder() 指向堆中空间
        String t2 = "helloking";
        System.out.println(t1.intern() == t2); // t
        // intern() 返回池中常量池字符串地址
    }
}

class Animal {
    String name;
    String gender;

    public Animal(String name) {
        this.name = name;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Animal animal = (Animal) o;
//        return Objects.equals(name, animal.name) &&
//                Objects.equals(gender, animal.gender);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(name, gender);
//    }
}
