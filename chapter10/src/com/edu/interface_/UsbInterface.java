package com.edu.interface_;

public interface UsbInterface { // 接口
    // 规定接口的相关方法
    // 接口方法默认 abstract public
    // JDK8 之后interface 可以写默认或静态方法(有方法体)
    void start(); // Interface abstract methods cannot have body
    void stop();

}
