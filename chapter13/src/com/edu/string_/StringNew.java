package com.edu.string_;

public class StringNew {
    public static void main(String[] args) {
        // 直接赋值
        // 1.常量池是否有数据空间,有就直接指向
        // 2.没有就重新创建,然后指向
        // 3.最终指向常量池的数据空间
        String s1 = "king";
        // new
        // 1.堆中创建value,指向常量池数据空间
        // 2.栈中引用指向堆value
        String s2 = new String("king");
        System.out.println("s1.hashCode() = " + s1.hashCode());
        System.out.println("s2.hashCode() = " + s2.hashCode());
        System.out.println("\"king\".hashCode() = " + "king".hashCode());
        System.out.println("s1.equals(s2) = " + s1.equals(s2)); // true
        System.out.println(s1 == s2); // false

        String a = "abc";
        String b = "abc";
        System.out.println(a == b); // true
    }
}
