package com.edu.super_;

/**
 *  0299
 * super 代表父类的引用,可以访问父类的构造器,方法,属性
 * super 不能访问 private
 * super 向上查找遵循就近原则
 */
public class Super01 {
    public static void main(String[] args) {
        B b = new B();
        b.sum();
        b.hi();
    }
}
