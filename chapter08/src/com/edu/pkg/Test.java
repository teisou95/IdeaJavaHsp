package com.edu.pkg;

import com.edu.modefier.A;

public class Test {
    public static void main(String[] args) {
        A a = new A();
        // 不同包 只能访问public,其他都不行
        a.m1();
        System.out.println("a.n1 = " + a.n1);
//        System.out.println("a.n2 = " + a.n2); // 'n2' has protected access in 'com.edu.modefier.A
//        System.out.println("a.n3 = " + a.n3);
//        // 'n3' is not public in 'com.edu.modefier.A'.Cannot be accessed from outside package
//        System.out.println("a.n4 = " + a.n4); // 'n4' has private access in 'com.edu.modefier.A'
    }
}
