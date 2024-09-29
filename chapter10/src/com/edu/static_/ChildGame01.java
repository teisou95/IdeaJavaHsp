package com.edu.static_;

/**
 * static 变量 / 类变量 / 静态变量
 * 不属于对象的属性,而是属于类的属性,所有对象共有
 * 在类加载的时候就生成 static 变量
 */
public class ChildGame01 {
    public static void main(String[] args) {

        Child king = new Child("king");
        Child wang = new Child("wang");
        Child li = new Child("li");

        king.join();

        wang.join();

        li.join();


        System.out.println("共有" + Child.getCount() + "人加入游戏");

        System.out.println("Child.getCount() = " + Child.getCount());
        System.out.println("king.getCount() = " + king.getCount());
        System.out.println("li.getCount() = " + li.getCount());
        System.out.println("wang.getCount() = " + wang.getCount());

    }
}
