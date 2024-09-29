package com.edu.extend_.exercise;

class ExtendsExercise02 {
    public static void main(String[] args) {
        C c = new C();
        /*
        输出:
         A 类无参构造
         B 类有参构造
         C 类有参构造
         C 类无参构造
         */
    }
}

class A02 {
    public A02() {
        System.out.println("A 类无参构造");
    }
}

class B02 extends A02 {
    public B02() {
        System.out.println("B 类无参构造");
    }

    public B02(String name) {
        System.out.println(name + "B 类有参构造");
    }
}

class C extends B02 {
    public C() {
        this("hello");
        System.out.println("C 类无参构造");
    }

    public C(String name) {
        super("hahaha");
        System.out.println("C 类有参构造");
    }
}