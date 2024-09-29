package com.edu.object.equals;

public class EqualsExercise02 {
    public static void main(String[] args) {
        Person02 p1 = new Person02();
        p1.name = "nana";

        Person02 p2 = new Person02();
        p2.name = "nana";

        System.out.println(p1 == p2); // F
        System.out.println(p1.name.equals(p2.name)); // T
        System.out.println(p1.equals(p2)); // F

        String s1 = new String("asdf");
        String s2 = new String("asdf");
        System.out.println(s1.equals(s2)); // T
        System.out.println(s1 == s2); // F

    }
}
