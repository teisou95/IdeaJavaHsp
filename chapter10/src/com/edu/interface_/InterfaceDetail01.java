package com.edu.interface_;

public class InterfaceDetail01 {
    public static void main(String[] args) {
//        new IA(); // 接口不能被实例化
    }
}

interface IA {
    void say(); // 省略了 默认的 public abstract
    void hi();
}
class AA implements IA { // alt + enter 快捷键 实现方法
    @Override
    public void say() {

    }

    @Override
    public void hi() {

    }
}

abstract class BB implements IA {
    // 抽象类实现接口,可以不实现接口的抽象方法
}