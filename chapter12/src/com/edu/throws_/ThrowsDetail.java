package com.edu.throws_;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ThrowsDetail {
    public static void main(String[] args) { // 默认throws 给 JVM机
        try {
            f2();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void f2() { // 默认 throws 给 main方法
        int n1 = 10;
        int n2 = 0;
        double res = n1 / n2;
    }
    public static void f1() throws FileNotFoundException{
        f3(); // Unhandled exception: java.io.FileNotFoundException
    }
    public static void f3() throws FileNotFoundException {
    }
    public static void f4() {
        f5(); // f5() 抛出的是运行异常,有默认的处理机制,不需要显式地处理
    }
    public static void f5() throws ArithmeticException {

    }
}

class Father {
    public void method() throws RuntimeException {

    }
}
class Son extends Father {
    // 子类重写父类的方法时,对抛出异常的规定,与父类一致或者是父类抛出异常的子类
    @Override
    public void method() throws NullPointerException {
        super.method();
    }

//    @Override
//    public void method() throws RuntimeException {
//        super.method();
//    }
}