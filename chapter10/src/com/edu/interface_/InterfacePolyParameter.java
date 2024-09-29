package com.edu.interface_;

/**
 * 接口的多态
 * 接口类型的变量 可以指向 实现了该接口的 类的 对象实例,和继承类似
 */
public class InterfacePolyParameter {
    public static void main(String[] args) {
        IF if01 = new Monster();
        if01 = new Car();
    }
}
interface IF {}
class Monster implements IF {}
class Car implements IF {}
