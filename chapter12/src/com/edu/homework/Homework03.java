package com.edu.homework;
// B C D
public class Homework03 {
    public static void main(String[] args) {
        try {
            func();
            System.out.println("A");
        }catch (Exception e) {
            System.out.println("C");
        }finally {
            System.out.println("D");
        }
    }
    public static void func() {
        try {
            throw new RuntimeException();
        }finally {
            System.out.println("B");
        }
    }
}
