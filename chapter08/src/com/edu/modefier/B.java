package com.edu.modefier;

public class B {
    public void say() {
        A a = new A();
        // 同包 可以访问 public protected 默认,不能访问private
        System.out.println("a.n1 = " + a.n1);
        System.out.println("a.n2 = " + a.n2);
        System.out.println("a.n3 = " + a.n3);
//        System.out.println("a.n4 = " + a.n4); // 'n4' has private access in 'com.edu.modefier.A'

        a.m1();
        a.m2();
        a.m3();
//        a.m4(); // 'm4()' has private access in 'com.edu.modefier.A'
    }
}
