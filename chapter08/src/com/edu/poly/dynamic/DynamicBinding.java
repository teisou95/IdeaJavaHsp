package com.edu.poly.dynamic;

/**
 * 动态绑定机制
 * 调用对象方法时,该方法会和该对象的内存地址(即运行类型)绑定
 * 调用对象属性时,没有动态绑定机制,哪里声明,哪里使用
 */
public class DynamicBinding {
    public static void main(String[] args) {
        A a = new B();
        System.out.println(a.sum()); // 30
        System.out.println(a.sum1()); // 20
        B b = new B();
        System.out.println(b.sum1()); // 20
    }
}

class A {
    public int i = 10;

    public int sum() {
        return getI() + 10; // getI() 也是a.getI(),仍然从运行类型出发,子类开始查找
    }

    public int sum1() {
        return i + 10; // 对象属性,哪里声明,哪里使用
    }

    public int getI() {
        return i;
    }
}

class B extends A {
    public int i = 20;

//    @Override
//    public int sum() {
//        return i + 20;
//    }

    @Override
    public int getI() {
        return i;
    }

//    @Override
//    public int sum1() {
//        return i + 10;
//    }
}