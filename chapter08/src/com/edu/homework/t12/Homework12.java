package com.edu.homework.t12;

public class Homework12 {
    public static void main(String[] args) {
        System.out.println("== 和 equals 的区别:");
        System.out.println("名称\t概念\t\t用于基本数据类型\t用于引用类型");
        System.out.println("==\t\t比较运算符\t数据是否相等\t\t是否为同一对象");
        System.out.println("equals\tObject类的方法\t不能使用\t\t是否为同一对象(但往往重写为判断对象内容是否相同)");
    }
}
