package com.edu.enumeration_;

/**
 * @author TeiSou
 * @version 1.0
 * Enum 类的各种方法的使用
 */
public class EnumMethod {
    public static void main(String[] args) {
        Season03 spring = Season03.SPRING;

        // name方法,输入枚举对象的名字
        System.out.println("spring.name() = " + spring.name()); // SPRING

        // ordinal 方法,输出该枚举对象的次序(编号)
        System.out.println("spring.ordinal() = " + spring.ordinal()); // 0
        System.out.println("Season03.SUMMER.ordinal() = " + Season03.SUMMER.ordinal()); // 1

        // values 方法,隐藏了的方法,返回定义的所有枚举对象
        Season03[] season03s = Season03.values();
//        for (int i = 0; i < season03s.length; i++) {
//            System.out.println("season03s[" + i + "] = " + season03s[i]);
//        }
        // 增强 for 循环,依次从数组中取值赋给变量,遍历结束退出循环
        for (Season03 season03:
             season03s) {
            System.out.println(season03);
        }

        // valueof 方法,根据提供的 String 去枚举类中查找对象
        // 找到就返回对象,没找到报错
        Season03 spring03 = Season03.valueOf("SPRING");
        System.out.println("spring02.name() = " + spring03.name());
        System.out.println((spring == spring03));
//        Season03.valueOf("WINTER"); // No enum constant com.edu.enumeration_.Season03.WINTER

        // compareTo 方法,比较两个枚举常量的编号
        // return self.ordinal - other.ordinal;
        System.out.println(Season03.SPRING.compareTo(Season03.SUMMER)); // -1
        System.out.println(Season03.SUMMER.compareTo(Season03.SPRING)); // 1
    }
}

enum Season03 {
    SPRING("温暖"),
    SUMMER("炎热");
    private String desc; // 描述

    Season03(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}