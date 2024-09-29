package com.edu.debug;

public class Debug01 {
    public static void main(String[] args) {
        // F8 逐行执行 debug
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += i;
            System.out.println("i = " + i);
            System.out.println("sum = " + sum);
        }
        System.out.println("end...");
    }
}
