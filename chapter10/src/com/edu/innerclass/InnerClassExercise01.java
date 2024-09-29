package com.edu.innerclass;

/**
 * 匿名内部类当作实参直接传递
 */
public class InnerClassExercise01 {
    public static void main(String[] args) {
        show(new AA() {
            @Override
            public void cry() {
                System.out.println("接口 AA 的匿名内部类(实现类)的一个对象传进来了");
            }
        });
        // 等价于以下传统方式
        show(new Car());
    }
    public static void show(AA aa) { // 形参就是接口类型
        aa.cry();
    }
}

interface AA {
    void cry();
}

// 硬编码,不推荐
class Car implements AA {
    @Override
    public void cry() {
        System.out.println("实现类");
    }
}