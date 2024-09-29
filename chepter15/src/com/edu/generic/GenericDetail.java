package com.edu.generic;

import java.util.ArrayList;

/**
 * 泛型 指向的数据类型必须是引用数据类型
 * 指定泛型后,可以传入其子类类型数据
 */
public class GenericDetail {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
//        ArrayList<int> ints = new ArrayList<int>(); // Type argument cannot be of primitive type

        //
        ArrayList<Father> fathers = new ArrayList<>();
        fathers.add(new Son()); // ok
        System.out.println(fathers);

        Pig<Father> fatherPig = new Pig<>(new Father()); // ok
        fatherPig.f();
        Pig<Father> pig = new Pig<>(new Son()); // E = Father,但传入了 Son 的对象,也ok
        pig.f();

        // 泛型定义形式
        ArrayList<Father> fathers1 = new ArrayList<>(); // 推荐简写,编译器会自动判断
        ArrayList<Father> fathers2 = new ArrayList<Father>(); // 未省略

        // 默认 E = Object 泛型不定义默认
        Pig pig1 = new Pig(new Object());
        pig1.setE(30);
        Pig<Object> objectPig = new Pig<>(new Object()); // 不指定泛型,等价于这种形式


    }
}

class Father {}
class Son extends Father {}
class Pig<E> {
    private E e;

    public void setE(E e) {
        this.e = e;
    }

    public Pig(E e) {
        this.e = e;
    }
    public void f() {
        System.out.println(e.getClass());
    }
}