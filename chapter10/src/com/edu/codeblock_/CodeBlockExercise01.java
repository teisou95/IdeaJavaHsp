package com.edu.codeblock_;

public class CodeBlockExercise01 {
    public static void main(String[] args) {
        System.out.println("total = " + Person.total); // 1.类加载 // 6.输出
        System.out.println("total = " + Person.total); // 7.输出
//        in static block!
//        total = 100
//        total = 100
    }
}

class Person {
    public static int total; // 2.静态初始化
    static { // 3.静态代码块
        total = 100; // 4
        System.out.println("in static block!"); // 5
    }
}