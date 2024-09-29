package com.edu.string_;

public class StringExercise06 {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "java";
        String s5 = "abcjava";
        String s6 = (s1 + s2).intern();
        System.out.println(s5 == s6); // t
        System.out.println(s5.equals(s6)); // t
    }
}
