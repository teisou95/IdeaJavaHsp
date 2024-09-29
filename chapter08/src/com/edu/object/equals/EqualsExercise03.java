package com.edu.object.equals;

public class EqualsExercise03 {
    public static void main(String[] args) {
        int n1 = 65;
        float f1 = 65.0F;
        System.out.println(n1 == f1); // T

        char c1 = 'A';
        char c2 = 12;
        System.out.println(n1 == c1); // T
        System.out.println(12 == c2); // T

        String s1 = new String("hello");
        String s2 = new String("hello");
        System.out.println(s1 == s2); // F
        System.out.println(s1.equals(s2)); // T
//        System.out.println("hello" == new java.sql.Date(1989,4,5));
        // java: 不可比较的类型: java.lang.String和java.sql.Date
    }
}
