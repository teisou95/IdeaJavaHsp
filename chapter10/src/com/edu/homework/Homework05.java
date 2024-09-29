package com.edu.homework;

public class Homework05 {
    public static void main(String[] args) {
        A a = new A("wang");
        a.m1();
    }
}
class A {
    private String name;

    public A(String name) {
        this.name = name;
    }

    public void m1() {
        class B { // 局部内部类
            private final String NAME = "king";
            public void show() {
                System.out.println("NAME = " + NAME);
                System.out.println("name = " + name);
//                System.out.println("A.this.name = " + A.this.name); // 重名处理
            }
        }
        new B().show();
    }
}
