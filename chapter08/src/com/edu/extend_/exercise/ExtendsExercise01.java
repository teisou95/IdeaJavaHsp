package com.edu.extend_.exercise;


public class ExtendsExercise01 {
    public static void main(String[] args) {
        B b = new B();
        /*
            a
            b name
            b
         */
    }
}

class A {
    A() {
        System.out.println("a");
    }

    A(String name) {
        System.out.println("a name");
    }
}

class B extends A {
    B() {
        this("abc"); // this super 不共存
        System.out.println("b");
    }

    B(String name) {
//        super(); // 默认无参 super
        System.out.println("b name");
    }
}