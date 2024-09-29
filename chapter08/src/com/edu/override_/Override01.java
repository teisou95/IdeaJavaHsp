package com.edu.override_;

/**
 * 方法重写/方法覆盖
 * 子类有一个方法,与父类某个方法的 名称 && 返回类型 && 参数 一样,就称为 子类方法覆盖了父类方法
 * 其中返回类型也可以:子类返回类型是父类返回类型的子类
 *
 * 子类与父类中同名 同形参列表的方法,返回类型也必须是子类与父类的关系,或者一样,否则报错
 * 子类方法不能缩小父类的访问权限
 * 父类中的 private 方法不能被重写
 */
public class Override01 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.cry(); // ctrl + B 定位
    }
}
