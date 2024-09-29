package com.edu.innerclass;

/**
 * 成员内部类
 * 定义在外部类的成员位置,且不是 static
 */
public class MemberInnerClass01 {
    public static void main(String[] args) {
        Outer06 outer06 = new Outer06("king");
        Outer06.Inner06 inner06 = outer06.new Inner06(); // 必须现有外部类对象,才能创建成员内部类对象
        outer06.getInner06Instance().say();
        new Outer06("wang").new Inner06().say();
        inner06.say();
        outer06.t1();

    }
}

class Outer06 {
    private int n1 = 10;
    private String name;

    public void say() {
        System.out.println("外部类的say");
    }

    public Outer06(String name) {
        this.name = name;
    }

    // 可以添加任意访问修饰符
    public class Inner06 { // 成员内部类
        private double sal = 32.5;
        private int n1 = 200;
        public void say() {
            // 可以直接访问外部类所有成员
            System.out.println("n1 = " + n1); // 重名 访问就近原则
            System.out.println("name = " + name);
            System.out.println("Outer06.this.n1 = " + Outer06.this.n1);
            Outer06.this.say();
        }
    }

    public void t1() {
        // 外部类方法可以直接使用成员内部类
        new Inner06() {
            @Override
            public void say() {
                System.out.println("成员内部类的匿名内部类");
            }
        }.say();
        double sal = new Inner06().sal;
    }

    // 返回一个成员内部类的实例
    public Inner06 getInner06Instance() {
        return new Inner06();
    }
}
