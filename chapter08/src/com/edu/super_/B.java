package com.edu.super_;

public class B extends A {
    public int n1 = 888;
    public void hi() {
        System.out.println("n1 = " + n1);
        System.out.println("this.n1 = " + this.n1);
        System.out.println("super.n1 = " + super.n1);
        System.out.println("n2 = " + n2);
        System.out.println("this.n2 = " + this.n2);
        System.out.println("super.n2 = " + super.n2);
        System.out.println("super.n3 = " + super.n3);
    }

    public void ok() {
        super.test1();
        super.test2();
        super.test3();
    }

    public B() {
        super();
    }

    public void cal() {
        System.out.println("B 的cal");
    }

    public void sum() {
        // 调用父类的cal ,没有重名的情况,三种方法是一样的
        // 有重名则不同
        cal();
        this.cal();
        super.cal(); // 直接从父类开始查找
        super.eat();

    }
}
