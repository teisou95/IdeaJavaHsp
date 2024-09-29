package com.edu.homework.t15;

/**
 * 方法的多态:重载/重写
 * 对象的多态:编译类型 运行类型
 * 编译类型是定义后确定不变化的,运行类型可以变化
 */
public class Homework15 {
    public static void main(String[] args) {
        AAA obj = new BBB(); // 向上转型
        System.out.println("obj的运行类型是" + obj.getClass()); // BBB
        AAA b1 = obj;
        obj = new CCC();
        System.out.println("obj的运行类型是" + obj.getClass()); // CCC
        obj = b1;
        System.out.println("obj的运行类型是" + obj.getClass()); // BBB
        obj = new AAA();
        System.out.println("obj的运行类型是" + obj.getClass()); // AAA
    }
}
class AAA {

}
class BBB extends AAA {

}
class CCC extends BBB {

}
