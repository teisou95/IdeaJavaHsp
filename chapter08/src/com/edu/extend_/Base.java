package com.edu.extend_;

// 父类 Base
public class Base extends TopBase {
    public int n1 = 100;
    protected int n2 = 200;
    int n3 = 300;
    private int n4 = 400;

    public Base(int n1, int n2, int n3, int n4) {
        System.out.println("父类的有参数构造器");
        this.n1 = n1;
        this.n2 = n2;
        this.n3 = n3;
        this.n4 = n4;
    }

    public Base() {
        System.out.println("父类的无参构造器 Base()...");
    }

    public int getN4() {
        return n4;
    }

    public void test100() {
        System.out.println("public 方法 test100()...");
    }

    protected void test200() {
        System.out.println("protected 方法 test200()...");
    }

    void test300() {
        System.out.println("默认 方法 test300()...");
    }

    private void test400() {
        System.out.println("private 方法 test400()...");
    }

    public void callTest400() {
        System.out.println("通过callTest400()调用test400()");
        test400();
    }
}
