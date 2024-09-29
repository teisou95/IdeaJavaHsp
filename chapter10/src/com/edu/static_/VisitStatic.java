package com.edu.static_;

/**
 * 类变量访问方法
 */
public class VisitStatic {
    public static void main(String[] args) {
        // 类名.类变量名
        System.out.println(A.name);
        System.out.println(A.getPriName());

        // 对象名.类变量名
        // 不规范的方式
        A a = new A();
        System.out.println(a.name);
        System.out.println(a.getPriName());
    }
}

class A {
    // 类变量的方法同样必须遵守访问权限
    public static String name = "hello";
//    static public String name = "hello"; // 这样写也可以

    private static String priName = "hahah";

    public static String getPriName() {
        return priName;
    }
}