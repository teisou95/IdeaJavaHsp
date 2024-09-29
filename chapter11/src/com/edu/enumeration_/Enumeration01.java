package com.edu.enumeration_;

/**
 * @author TeiSou
 * @version 1.0
 * 枚举
 * 一种特殊的类,类中只包含有限的特定的对象
 * 1.自定义枚举
 * 2.enumeration 关键字
 */
public class Enumeration01 {
    public static void main(String[] args) {
        System.out.println("Season.SPRING = " + Season.SPRING);

    }
}

class Season {
    private final String name;
    private final String desc; // 描述

    // 采用类似 单例模式-饿汉式 设计,保证对象的固定
    private Season(String name, String desc) { // 构造器私有化,防止直接 new
        this.name = name;
        this.desc = desc;
    }

    // 类的内部创建固定的对象
    // Season 类的对象是固定的4个,不会有更多
    // final 修饰的静态常量 可以在不加载类的情况下直接取出
    public static final Season SPRING = new Season("春天", "温暖");
    public static final Season WINTER = new Season("冬天", "寒冷");
    public static final Season SUMMER = new Season("夏天", "炎热");
    public static final Season AUTUMN = new Season("秋天", "凉爽");

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
