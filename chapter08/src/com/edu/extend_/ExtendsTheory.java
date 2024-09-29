package com.edu.extend_;

/**
 * 继承的本质
 *
 */
public class ExtendsTheory {
    public static void main(String[] args) {
        Son son = new Son();
        /**
         * 对象创建的内存变化
         * 1.方法区加载类 Object - GrandPa - Father - Son,同时类之间有继承的关联关系
         * 2.堆中分配对象地址空间,从GrandPa - Father - Son 逐个初始化,String 指向方法区常量池,int 直接保存
         * 3.main 栈中对象引用son 指向堆中的对象
         */
        /**
         * 按照查找关系返回数据
         * 1.首先看子类是否有
         * 2.如果子类有且可以访问,就返回信息
         * 3.如果子类没有,就看父类有没有
         */
        System.out.println("son.name = " + son.name);
        System.out.println("son.getName = " + son.getName());
    }
}

class GrandPa {
    String name = "爷爷";
    String hobby = "旅游";

    public String getName() {
        return name;
    }
}

class Father extends GrandPa {
    private String name = "爸爸";
    int age = 39;

    public String getName() {
        return name;
    }
}

class Son extends Father {
    String name = "儿子";
}