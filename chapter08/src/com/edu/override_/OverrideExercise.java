package com.edu.override_;

public class OverrideExercise {
    public static void main(String[] args) {
        Person jack = new Person("jack", 25);
        Student king = new Student("king", 30, "abc111", 60.5);
        System.out.println(jack.say());;
        System.out.println(king.say());
    }
}
