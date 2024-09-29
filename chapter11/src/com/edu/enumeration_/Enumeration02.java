package com.edu.enumeration_;

import java.util.Enumeration;

/**
 * 0427
 * @author TeiSou
 * @version 1.0
 * 使用 enumeration 关键字实现枚举类
 */

public class Enumeration02 {
    public static void main(String[] args) {
        System.out.println("Season02.SPRING = " + Season02.SPRING);
    }
}
/*
    javap 反编译:
    Compiled from "Enumeration02.java"
    final class com.edu.enumeration_.Season02 extends java.lang.Enum<com.edu.enumeration_.Season02> {
      public static final com.edu.enumeration_.Season02 SPRING;
      public static final com.edu.enumeration_.Season02 WINTER;
      public static final com.edu.enumeration_.Season02 AUTUMN;
      public static final com.edu.enumeration_.Season02 SUMMER;
      public static com.edu.enumeration_.Season02[] values();
      public static com.edu.enumeration_.Season02 valueOf(java.lang.String);
      public java.lang.String getName();
      public java.lang.String getDesc();
      public java.lang.String toString();
      static {};
    }
 */
// enum 关键字 的类 默认继承 Enum 类,而且是一个final类
enum Season02 { // 枚举类

    // 如果使用了 enum 关键字
    // 1.使用关键字 enum 替代 class
    // 2.public static final Season02 SPRING = new Season02("春天", "温暖"); 使用 SPRING("春天", "温暖"); 替代
    //      常量名(实参列表);
    // 3.如果有多个,使用 , 间隔
    // 4.常量必须写在最前面
    // 5.省略了 public final static
    SPRING("春天", "温暖"),
    WINTER("冬天", "寒冷"),
    AUTUMN("秋天", "凉爽"),
    SUMMER("夏天", "炎热");
//    OTHER(), // 调用了无参构造器
//    WHAT; // 可以简化到连括号都不用
    private String name;
    private String desc; // 描述;

    // 采用类似 单例模式-饿汉式 设计,保证对象的固定
    private Season02(String name, String desc) { // 构造器私有化,防止直接 new
        this.name = name;
        this.desc = desc;
    }
//    private Season02() { //无参构造器
//
//    }

    // 类的内部创建固定的对象
    // Season 类的对象是固定的4个,不会有更多
    // final 修饰的静态常量 可以在不加载类的情况下直接取出
//    public static final Season02 SPRING = new Season02("春天", "温暖");
//    public static final Season02 WINTER = new Season02("冬天", "寒冷");
//    public static final Season02 SUMMER = new Season02("夏天", "炎热");
//    public static final Season02 AUTUMN = new Season02("秋天", "凉爽");



    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}