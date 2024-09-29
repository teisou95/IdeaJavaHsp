package com.edu.homework.t10;

public class Homework10 {
    public static void main(String[] args) {
        Doctor king = new Doctor("king", 35, "docter", '男', 25000);
        Doctor wang = new Doctor("king", 35, "docter", '男', 25000);
        Doctor li = new Doctor("li", 26, "docter", '男', 13000);
        System.out.println("king == wang: " + (king == wang));
        System.out.println("king.equals(wang): " + king.equals(wang));
        System.out.println("li == wang: " + (li == wang));
        System.out.println("li.equals(wang): " + li.equals(wang));
        System.out.println("king.hashCode() = " + king.hashCode());
        System.out.println("wang.hashCode() = " + wang.hashCode());
        System.out.println("li.hashCode() = " + li.hashCode());
    }
}
