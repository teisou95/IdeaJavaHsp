package com.edu.homework.t14;

public class C extends B {
    public C() {
        this("hello"); // 1
        System.out.println("C类无参构造"); // 8
    }

    public C(String name) {
        super("hahah"); // 2
        System.out.println("C类有参构造"); // 7
    }
}
