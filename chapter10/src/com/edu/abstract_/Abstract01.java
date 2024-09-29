package com.edu.abstract_;

/**
 * 抽象类 抽象方法
 */
public class Abstract01 {
    public static void main(String[] args) {

    }
}

abstract class Animal { // 抽象类
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    // 父类方法的不确定性问题
    // => 将该方法设计为抽象方法(abstract method)
    // ==> 没有实现的方法(没有方法体)
    // 抽象类会被继承,由子类重写实现
    // 类中存在抽象方法时,需要将类声明为 abstract
//    public void eat() {
//        System.out.println("动物吃东西");
//    }
    public abstract void eat(); // Abstract method in non-abstract class 抽象方法必须写在抽象类
}