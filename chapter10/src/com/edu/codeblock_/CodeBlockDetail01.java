package com.edu.codeblock_;

/**
 * static 代码块,随着类加载执行,只执行一次
 * 普通    代码块,每创建一个对象,就执行一次
 *
 * 什么时候类加载:
 * 1.创建对象实例时
 * 2.创建子类对象实例时,父类也会被加载
 * 3.使用类的静态成员时
 *
 * 如果只是使用类的静态成员(并没有创建对象实例),普通代码块不会被执行
 */
public class CodeBlockDetail01 {
    public static void main(String[] args) {
        A.getCount();
        System.out.println("===================");
        new A("king"); // 静态代码块不再重复执行
        System.out.println("===================");
        new A("mary"); // 静态代码块不再重复执行
        System.out.println("===================");

    }
}
class B {
    {
        System.out.println("父类普通代码块"); // 3. 创建父类对象
    }
    static {
        System.out.println("父类静态代码块"); // 1.加载父类
    }

    public B() {
        System.out.println("父类构造器"); // 4.调用父类无参构造器
    }
}

class A extends B {
    private String name;
    private static int count;

    public static int getCount() {
        return count;
    }

    {
        System.out.println("子类普通代码块"); // 5.创建子类对象
    }
    static {
        System.out.println("子类静态代码块"); // 2.加载子类
    }

    public A(String name) {
        System.out.println("子类构造器"); // 6.调用子类构造器
        this.name = name;
    }
}