package com.edu.customgeneric;


import java.util.ArrayList;

public class CustomGenericMethod {
    public static void main(String[] args) {
        Bird<Object, Object, Object> bird = new Bird<>();
        bird.fly("kaka"); // 泛型方法在调用时指定类型
        Car<String, String> car = new Car<>();
        car.<Integer,Double>fly(12,10.6);
        car.fly("ad","csd");
        bird.getX(new ArrayList<String>()).add("fcsd");

    }
}
class Bird<T,R,M> {
    public<X> void fly(X x) {
        System.out.println("x = " + x);
    }
    public <X> X getX(X x) {
        return x;
    }

}
class Car<T,R> {
    public void run(T t,R r) { //使用了类声明的泛型

    }
    // 泛型方法定义
    public<T,R> void fly(T t,R r) { // 就近原则
        System.out.println("t.getClass() = " + t.getClass());
    }
}
