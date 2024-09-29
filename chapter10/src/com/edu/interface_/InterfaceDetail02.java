package com.edu.interface_;

import java.lang.reflect.AnnotatedArrayType;

public class InterfaceDetail02 {
    public static void main(String[] args) {
        System.out.println(IB.NUM); //


    }
}

interface IB { // 接口不能继承类,但可以继承多个其他接口
    int NUM = 1; // 接口属性默认 public static final
    void hi();
    void say();
}

interface IC {
    void hi();
    void hello();

}

class AAA implements IB, IC { // 一个类可以多接口


    @Override
    public void hi() {

    }

    @Override
    public void hello() {

    }

    @Override
    public void say() {

    }
}