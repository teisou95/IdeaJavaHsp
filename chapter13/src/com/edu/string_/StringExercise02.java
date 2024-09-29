package com.edu.string_;

public class StringExercise02 {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "java";
        String s3 = new String("java");
        String s4 = "java";

        System.out.println(s2 == s3); // f
        System.out.println(s2 == s4); // t
        System.out.println(s2.equals(s3)); // t
        System.out.println(s1 == s2); // f
    }
}
