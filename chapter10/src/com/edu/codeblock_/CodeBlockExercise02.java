package com.edu.codeblock_;

public class CodeBlockExercise02 {
    public static void main(String[] args) {
        Test test = new Test(); // 1.Test 类加载
        System.out.println(Test.sam);
    }
}

class Sample {
    public Sample() {
        System.out.println("Sample 默认构造器");
    }
    public Sample(String s) {
        System.out.println(s);
    }
}

class Test {
    Sample sam1 = new Sample("普通成员初始化"); // 4
    static Sample sam = new Sample("静态成员初始化"); // 2
    static {
        System.out.println("静态代码块"); // 3
        if (sam == null) System.out.println("sam is null"); // false 有引用指向就不为空
    }

    public Test() {
        // super();
        // 普通代码块&普通成员初始化;
        System.out.println("Test 默认构造器"); // 5
    }
}