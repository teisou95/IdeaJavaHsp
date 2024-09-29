package com.edu.exception;

/**
 * 类型转换异常
 */
public class ClassCastException_ {
    public static void main(String[] args) {
        A a = new B();
        B b = (B)a;
        try {
            C c = (C)a;
        } catch (Exception e) {
            System.out.println(e);
            // java.lang.ClassCastException: com.edu.exception.B cannot be cast to com.edu.exception.C
        }
    }
}
class A {}
class B extends A {}
class C extends A {}