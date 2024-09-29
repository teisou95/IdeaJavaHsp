package com.edu.homework.t07;

/**
 * 输出结果:
 * Test
 * Demo
 * Rose
 * Jack
 * john
 * Jack
 */
public class Homework07 {
    public static void main(String[] args) {
        new Demo().test(); // 匿名对象
        new Demo("john").test();
    }
}
