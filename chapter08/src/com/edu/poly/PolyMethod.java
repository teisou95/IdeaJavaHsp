package com.edu.poly;

/**
 * 方法的多态:重载和重写
 */
public class PolyMethod {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(a.sum(10, 20));
        System.out.println(a.sum(10, 20, 30));
        a.say();
        B b = new B();
        b.say();

    }
}

class B {
    public void say() {
        System.out.println("B say()");
    }
}

class A extends B {
    // 重载
    public int sum(int n1, int n2) {
        return n1 + n2;
    }
    public int sum(int n1, int n2,int n3) {
        return n1 + n2 + n3;
    }

    // 重写
    @Override
    public void say() {
        System.out.println("A say()");
    }
}

