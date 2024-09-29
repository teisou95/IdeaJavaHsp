package com.edu.abstract_;

/**
 * 1.抽象类不能被实例化
 * 2.抽象类不一定要包含抽象方法
 * 3.抽象方法不能使用 private final static,与重写相违背
 *      static 方法不能被重写，但可以被隐藏。
 *      重写是基于实例方法的动态绑定，而 static 方法是在编译时绑定的，因此不涉及多态性。
 *
 */
public class AbstractDetail {
    public static void main(String[] args) {
//        new A(); // 'A' is abstract; cannot be instantiated
    }
}

// 抽象类可以有普通类的各种成员,包括非抽象方法

abstract class A {
    public void say() {
    }
    public abstract void hello();
    public abstract int add(int n1);
}
// 抽象类的直接子类,必须实现抽象类的所有抽象方法,除非子类本身也是抽象类
class B extends A { //Class 'B' must either be declared abstract or implement abstract method 'add(int)' in 'A'
    @Override
    public void hello() {

    }

    @Override
    public int add(int n1) {
        return 0;
    }
}
// 间接子类可以不用实现抽象类的抽象方法
class C extends B {

}