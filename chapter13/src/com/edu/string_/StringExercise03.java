package com.edu.string_;

public class StringExercise03 {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.setName("abc");
        Person p2 = new Person();
        p2.setName("abc");

        System.out.println(p1.getName().equals(p2.getName())); // t
        System.out.println(p1.getName() == p2.getName()); // t
        System.out.println(p1.getName() == "abc"); // t

        String s1 = new String("bbb");
        String s2 = new String("bbb");
        System.out.println(s1 == s2); // f
    }
}
class Person {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}