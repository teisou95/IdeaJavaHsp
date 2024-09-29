package com.edu.main_;

public class Main01 {
    // 静态成员 可以被 main 方法直接使用
    private static String name = "king";
    private static void say() {
        System.out.println("hello");
    }

    // 非静态成员 需要创建对象后, main 方法才能调用
    private int num = 10;
    private int sum(int n1, int n2) {
        return n1 + n2;
    }

    public static void main(String[] args) {
        System.out.println("name = " + name);
        say();

        Main01 m = new Main01();
        System.out.println("m.num = " + m.num);
        System.out.println(m.sum(5,10));

        // 运行时传入 main 的 String 数组参数
        // idea 中运行时传入参数方式:
        // edit configurations -> program argument
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
    }
}
