package com.edu.codeblock_;

public class CodeBlockDetail03 {
    public static void main(String[] args) {
        BBB bbb = new BBB();
    }
}
class AAA {
    static {
        System.out.println("0.父类静态代码块"); // 0
    }
    {
        System.out.println("1.父类普通代码块"); // 1
    }
    public AAA() {
        // super();
        // 普通代码块
        System.out.println("2.父类构造器"); // 2
    }
}
class BBB extends AAA {
    static {
        System.out.println("00.子类静态代码块"); // 00
    }
    {
        System.out.println("3.子类普通代码块"); // 3
    }
    public BBB() {
        // super();
        // 普通代码块
        System.out.println("4.子类构造器"); // 4
    }
}