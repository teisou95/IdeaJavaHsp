package com.edu.poly.exercise;

/**
 * 多态
 * 判断程序执行结果
 * 属性没有重写,只看编译类型
 * 方法重写执行看运行类型
 */
public class PolyExercise02 {
    public static void main(String[] args) {
        Sub sub = new Sub();
        System.out.println(sub.count); // 20
        sub.display(); // 20

        Base base = sub;
        System.out.println(base == sub); // T 对象比较看引用地址
        System.out.println(base.count); // 10
        base.display(); // 20
    }
}

class Base {
    int count = 10;

    public void display() {
        System.out.println(this.count);
    }
}

class Sub extends Base {
    int count = 20;

    @Override
    public void display() {
        System.out.println(this.count);
    }
}
