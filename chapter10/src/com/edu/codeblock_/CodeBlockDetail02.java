package com.edu.codeblock_;

/**
 * 1.静态代码块 与 静态属性初始化 优先级最高,都是类加载同时执行,按代码顺序执行
 * 2.普通代码块 与 普通属性初始化 优先级其次,创建对象时执行,按代码顺序执行
 * 3.构造器 优先级最低(同时也是最终赋值,决定结果)
 */
public class CodeBlockDetail02 {
    public static void main(String[] args) {
        CC cc = new CC(500);
        System.out.println(cc.getN2()); // 500
    }
}

class CC {
    public CC(int n2) {
        // 构造器一开始隐藏了两个部分:
        // super();
        // 执行普通代码块
        System.out.println("构造器");
        this.n2 = n2;
    }

    private int n2 = setN2();
    {
        System.out.println("普通代码块");
    }
    private static int n1 = setN1();
    static {
        System.out.println("静态代码块");
    }
    public static int setN1() {
        System.out.println("静态变量调用了静态方法");
        return 100;
    }
    public int setN2() {
        System.out.println("普通属性调用了普通方法");
        return 200;
    }

    public int getN2() {
        return n2;
    }
}