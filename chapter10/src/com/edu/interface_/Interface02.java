package com.edu.interface_;

public interface Interface02 {
    // 属性,方法
    int n1 = 10;
    // 接口中抽象方法可以省略 abstract 关键字
    public void hi();
//    public void ok() { } // Interface abstract methods cannot have body
    default void ok() { // 默认实现方法

    }
    static public void hello() { // 静态方法

    }
}

class A implements Interface02 {
    @Override
    public void hi() {
        System.out.println("在A类中实现了Interface02 接口的 hi 方法");
    }
}